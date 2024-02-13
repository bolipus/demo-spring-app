import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService  {

  constructor(private httpClient: HttpClient) { }

  getUser(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:4200/api/public/user');
  }
}
