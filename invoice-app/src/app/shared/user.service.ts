import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { ListAllUser } from './model/user/list-user.model';
import { NewUser } from './model/user/new-user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "https://invoice-api-ludmylla.herokuapp.com/users";

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<ListAllUser[]> {
    return this.http.get<ListAllUser[]>(this.baseUrl)
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  newUser(newUser: NewUser): Observable<Object> {
    return this.http.post(this.baseUrl, newUser, { responseType: 'text' })
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  getUserFindById(id: number): Observable<NewUser> {
    return this.http.get<NewUser>(`${this.baseUrl}/${id}`)
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  updateUser(newUser: NewUser): Observable<Object>{
    return this.http.put(this.baseUrl, newUser,{ responseType: 'text' })
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  // Error handling
  handlerError(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent){
      // Get client side error
      errorMessage = error.error.message;
    }else {
      errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`;
    }
    // window.alert(errorMessage);
    return throwError(errorMessage);
  }
}
