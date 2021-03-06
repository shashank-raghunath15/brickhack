import { Component, OnInit } from '@angular/core';
import { Login } from '../../models/login';
import { LoginService } from '../../services/login.service';
import { User } from '../../models/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) {
  }

  ngOnInit() {
  }

  logIn(logIn: Login) {
    this.loginService.login(logIn).subscribe((user: User) => {
      localStorage.setItem('user', JSON.stringify(user));
      console.log(user);
    });
  }

}
