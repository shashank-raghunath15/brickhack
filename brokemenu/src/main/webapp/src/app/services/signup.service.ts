import { Injectable } from '@angular/core';
import { HttpClient, HttpClient } from "@angular/common/http";
import { Signup } from "../models/Signup";

@Injectable()
export class SignupService {

  constructor(private Htpp: HttpClient) {

  }

  Signup(Signup:Signup){
    return this.Http.post(Signup);
  }

}
