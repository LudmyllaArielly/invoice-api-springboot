import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ListAllUser } from './model/list-user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8080/users";

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<ListAllUser[]> {
    return this.http.get<ListAllUser[]>(this.baseUrl);
  }
}
