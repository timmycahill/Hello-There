import { Injectable } from '@angular/core';
import { User } from 'src/app/models/user';
import { Post } from 'src/app/models/post';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  // Base URL
  baseUrl = "/api/post"

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  // Write post (POST)
  writePost(content: string, author: User) {
    
    const post = {
      content: content,
      author: author
    }

    return this.http.post<Post>(this.baseUrl + '/create', post, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );

  }


  // Get all posts (GET)
  getPosts(): Observable<Post[]> {

    return this.http.get<Post[]>(this.baseUrl + '/all')
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }


  // Get user posts (GET)
  getUserPosts(user: User): Observable<Post[]> {

    return this.http.get<Post[]>(this.baseUrl + `/userPosts?username=${user.username}`)
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
