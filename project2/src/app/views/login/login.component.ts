import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/controllers/userController/user.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: User[] | undefined;
  currentUser: User | undefined;
  error: boolean = false;

  loginForm = new FormGroup ({
    username: new FormControl(''),
    password: new FormControl('')
  })

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem('user')) {
      this.router.navigate(["/home"]);
    }
  }

  login() {
    const username = this.loginForm.value.username;
    const password = this.loginForm.value.password;

    this.userService.LogIn(username, password).subscribe(data => { 
      this.users = data;

      if(!this.users[0]) {
        this.error = true;
      }
      else {
        console.log(this.users);
        sessionStorage.setItem('user', JSON.stringify(this.users[0]));
        this.userService.changeLoginStatus(true);
        this.router.navigate(['/home']);
      }
    });    
  }
}