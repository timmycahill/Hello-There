import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { FriendsService } from '../../controllers/friendController/friend.service';
import { Friend } from '../../models/friend';

@Component({
  selector: 'app-friends-sidebar',
  templateUrl: './friends-sidebar.component.html',
  styleUrls: ['./friends-sidebar.component.css']
})
export class FriendsSidebarComponent implements OnInit {

  user: User | undefined;
  friends : Friend[] | undefined;

  constructor(private friendsService : FriendsService) { }

  ngOnInit(): void {
    let userString = sessionStorage.getItem('user');
    if (userString) {
      this.user = JSON.parse(userString);
    }

    if (this.user) {
      this.friendsService.getFriends(this.user).subscribe(data => {
        this.friends = data;
      });
    }
  }

}
