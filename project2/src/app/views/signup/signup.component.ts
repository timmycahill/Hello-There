import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/controllers/userController/user.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{

  signupForm = new FormGroup({
    email: new FormControl(''),
    username: new FormControl(''),
    displayName: new FormControl(''),
    password: new FormControl(''),
    password2: new FormControl('')
  })

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem('user')) {
      this.router.navigate(["/home"]);
    }
  }

  submitData() {
    let email = this.signupForm.value.email;
    let username = this.signupForm.value.username;
    let displayName = this.signupForm.value.displayName;
    let password = this.signupForm.value.password;
    
    this.userService.CreateUser(email, username, displayName, password).subscribe();
    this.router.navigate(["/login"]);
  }
}
