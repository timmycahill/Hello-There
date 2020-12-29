import { Component, OnInit, Input } from '@angular/core';
import { CommentService } from 'src/app/controllers/commentController/comment.service';
import { LikeService } from 'src/app/controllers/likeController/like.service';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import { Comment } from 'src/app/models/comment';
import { Like } from 'src/app/models/like';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input() post: Post | undefined;
  image = "assets/images/profilePicture.png";
  writeComment: boolean = false;
  showComments: boolean = false;
  comments: Comment[] | undefined;
  likes: Like[] | undefined;
  liked: boolean = false;
  user: User | undefined;
  likeCount: number = 0;

  constructor(private likeService: LikeService, private commentService: CommentService) { }

  ngOnInit(): void {
    let userString = sessionStorage.getItem('user');
    if (userString) {
      this.user = JSON.parse(userString);
    }

    if (this.post) {
      this.likeService.getLikes(this.post).subscribe(data => {
        this.likes = data;
        this.likeCount = this.likes.length;
        
        this.likes.forEach((like) => {
          if (like.user.id == this.user?.id) {
            this.liked = true;
          }
        })
      })
    }
  }

  likePost() {
    if (this.user && this.post) {
      this.likeService.likePost(this.user, this.post).subscribe();
      this.liked = true;
      this.likeCount += 1;
    }
  }
  
  unlikePost() {
    if (this.user && this.post) {
      this.likeService.unlikePost(this.user, this.post).subscribe();
      this.liked = false;
      this.likeCount -= 1;
    }
  }
  
  toggleWriteComment() {
    this.writeComment = !this.writeComment;
  }

  toggleComments() {
    this.showComments = !this.showComments;
    if (!this.comments && this.post) {
      this.commentService.getComments(this.post).subscribe(data => {
        this.comments = data;
      })
    }
  }
}
