import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService  {

  constructor(private httpClient: HttpClient) { }

  private userApi = environment.apiUrl;

  getUser(): Observable<User> {
    return this.httpClient.get<User>(this.userApi+'/public/user');
  }
}
