import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { FriendsService } from '../../controllers/friendController/friend.service';
import { Friend } from '../../models/friend';

@Component({
  selector: 'app-friends-list',
  templateUrl: './friends-list.component.html',
  styleUrls: ['./friends-list.component.css']
})
export class FriendsListComponent implements OnInit {

  user: User | undefined;
  friends : Friend[] | undefined;

  constructor(private friendsService : FriendsService, private router: Router) { }

  ngOnInit(): void {
    let userString = sessionStorage.getItem('user');
    if (userString) {
      this.user = JSON.parse(userString);

      if (this.user) {
        this.friendsService.getFriends(this.user).subscribe(data => {
          this.friends = data;
        });
      }
    }
    else {
      this.router.navigate(["/login"]);
    }

  }

}