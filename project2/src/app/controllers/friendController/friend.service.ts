import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { User } from 'src/app/models/user';
import { Friend } from 'src/app/models/friend';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  // Base URL
  baseUrl = "/api/friend"

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  // Add Friend (POST)
  addFriend(user: User, friend: User) {
    
    const friendship = {
      user: user,
      friend: friend
    }

    return this.http.post(this.baseUrl + '/create', friendship, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );

  }


  // Get friends (GET)
  getFriends(user: User): Observable<Friend[]> {

    return this.http.get<Friend[]>(this.baseUrl + '/getall?userId=' + user.id)
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
