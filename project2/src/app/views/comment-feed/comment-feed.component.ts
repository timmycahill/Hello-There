import { Component, Input, OnInit } from '@angular/core';
import { Comment } from 'src/app/models/comment';

@Component({
  selector: 'app-comment-feed',
  templateUrl: './comment-feed.component.html',
  styleUrls: ['./comment-feed.component.css']
})
export class CommentFeedComponent implements OnInit {

  @Input() comments: Comment[] | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
