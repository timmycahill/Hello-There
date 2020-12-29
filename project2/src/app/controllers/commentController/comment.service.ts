import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import { Post } from 'src/app/models/post';
import { Comment } from 'src/app/models/comment';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  // Base URL
  baseUrl = "/api/comment"

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // Write comment (POST)
  writeComment(content: string, author: User, associatedPost: Post) {

    const comment = {
      content: content,
      author: author,
      associatedPost: associatedPost
    }

    return this.http.post<Post>(this.baseUrl + '/create', comment, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

    // Get comments (GET)
    getComments(post: Post): Observable<Comment[]> {
      return this.http.get<Comment[]>(this.baseUrl + '/get?postId=' + post.id)
      .pipe(
        retry(1),
        catchError(this.errorHandler)
      );
    }


    // Error handling
  errorHandler(error: any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
