import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/login';

@Injectable()
export class LoginService {

  constructor(private Http: HttpClient) {

  }

  login(logIn: Login) {
    return this.Http.post('http://localhost:8080/login', logIn);
  }

}
