import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';

@Injectable()
export class SignupService {

  constructor(private Http: HttpClient) {

  }

  signUp(user: User) {
    return this.Http.post('http://localhost:8080/signUp', user);
  }

}
