import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/controllers/postController/post.service';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-profile-feed',
  templateUrl: './profile-feed.component.html',
  styleUrls: ['./profile-feed.component.css']
})
export class ProfileFeedComponent implements OnInit {

  user: User | undefined;
  posts: Post[] | undefined;
  image = "assets/images/profilePicture.png";

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    let userString = sessionStorage.getItem('user');
    if (userString) {
      this.user = JSON.parse(userString);

      console.log(this.user);
      if (this.user) {
        this.postService.getUserPosts(this.user).subscribe(data => {
          this.posts = data;
        });
      }
    }
  }
}
