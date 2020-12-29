import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/controllers/postController/post.service';
import { Post } from '../../models/post';

@Component({
  selector: 'app-home-feed',
  templateUrl: './home-feed.component.html',
  styleUrls: ['./home-feed.component.css']
})
export class HomeFeedComponent implements OnInit {

  posts: Post[] | undefined; 
  

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.postService.getPosts().subscribe(data => {
      this.posts = data;
    });
  }

}
