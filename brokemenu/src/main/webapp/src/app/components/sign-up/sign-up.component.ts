import { Component, OnInit } from '@angular/core';
import { Signup } from '../../models/signup';
import { SignupService } from '../../services/signup.service';
import { User } from '../../models/User';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private signupService: SignupService) {
  }

  ngOnInit() {
  }

  signUp(user: User) {
    this.signupService.signUp(user).subscribe((res: User) => {
      console.log(res);
    });
  }

}
