import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/controllers/userController/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  loggedIn: boolean | undefined;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.userService.loginStatus.subscribe(status => this.loggedIn = status);
  }

  logout() {
    sessionStorage.clear();
    this.userService.changeLoginStatus(false);
    this.router.navigate(["/login"]);
  }
}
