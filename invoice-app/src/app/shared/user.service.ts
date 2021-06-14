import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ListAllUser } from './model/user/list-user.model';
import { NewUser } from './model/user/new-user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8080/users";

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<ListAllUser[]> {
    return this.http.get<ListAllUser[]>(this.baseUrl);
  }

  newUser(newUser: NewUser): Observable<Object> {
    return this.http.post(this.baseUrl, newUser, { responseType: 'text' });
  }

  getUserFindById(id: number): Observable<NewUser> {
    return this.http.get<NewUser>(`${this.baseUrl}/${id}`);
  }

  updateUser(newUser: NewUser): Observable<Object>{
    return this.http.put(this.baseUrl, newUser,{ responseType: 'text' });
  }
}
