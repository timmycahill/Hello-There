import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, retry } from 'rxjs/operators';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { User } from '../../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  user: any = sessionStorage.getItem('user');
  private loggedInSource = new BehaviorSubject<boolean>(this.user);
  loginStatus = this.loggedInSource.asObservable();

  
  
  // change login status
  changeLoginStatus(status: boolean) {
    this.loggedInSource.next(status);
  }

  // Base URL
  baseUrl = "/api/user";


  constructor(private http: HttpClient) { }



  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  // Create User (POST)
  CreateUser(email: string, username: string, displayName: string, password: string): Observable<User> {

    const userData = {
      email: email,
      username: username,
      displayName: displayName,
      password: password
    }

    return this.http.post<User>(this.baseUrl + '/create', userData, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );

  }


  // Log In (POST)
  LogIn(username: string, password: string): Observable<User[]> {

    const userData = {
      username: username,
      password: password
    }

    return this.http.post<User[]>(this.baseUrl + '/login', userData, this.httpOptions)
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
