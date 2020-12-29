import { Component, Input, OnInit } from '@angular/core';
import { Friend } from 'src/app/models/friend';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {

  @Input() friendship: Friend | undefined;
  friend: User | undefined;
  image = "assets/images/profilePicture.png";

  constructor() { }

  ngOnInit(): void {
    let userString = sessionStorage.getItem('user');
    if (userString && this.friendship) {
      let user = JSON.parse(userString);
      if (user == this.friendship.user) {
        this.friend = this.friendship.friend;
      }
      else {
        this.friend = this.friendship.user;
      }
    }
  }

}
