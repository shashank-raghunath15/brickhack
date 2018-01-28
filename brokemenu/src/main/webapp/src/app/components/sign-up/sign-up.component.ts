import { Component, OnInit } from '@angular/core';
import { Signup } from "../../models/sign-up";
import { SignupService} from "../../services/signup.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private SignupService:SignupService) {
  }

  ngOnInit() {
  }

  signUp(Signup:signUp){
    this.SignupService.signUp(Signup).subscribe((user: User)=>{
      localStorage.setItem("user", user);
    });
  }

}
