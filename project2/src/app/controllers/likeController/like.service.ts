import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import { Post } from 'src/app/models/post';
import { Like } from 'src/app/models/like';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class LikeService {

  // Base URL
  baseUrl = "/api/like"

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  
  // Like post (POST)
  likePost(user: User, post: Post) {
    let like: Like = {
      user: user,
      post: post
    }

    return this.http.post(this.baseUrl + '/create', like, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

  // Unlike post (DELETE)
  unlikePost(user: User, post: Post) {
    return this.http.delete(this.baseUrl + '/delete?postId=' + post.id + '&userId=' + user.id)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }



  // Get likes (GET)
  getLikes(post: Post): Observable<Like[]> {
    return this.http.get<Like[]>(this.baseUrl + '/get?postId=' + post.id)
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
