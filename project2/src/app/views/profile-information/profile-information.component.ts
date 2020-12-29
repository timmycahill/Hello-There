import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/controllers/userController/user.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-profile-information',
  templateUrl: './profile-information.component.html',
  styleUrls: ['./profile-information.component.css']
})
export class ProfileInformationComponent implements OnInit {

  image: string = "/assets/images/profilePicture.png";
  user: User | undefined;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    let userString = sessionStorage.getItem('user');
    console.log(userString);
    if (userString) {
      this.user = JSON.parse(userString);
    }
  }

}
