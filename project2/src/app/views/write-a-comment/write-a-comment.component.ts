import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CommentService } from 'src/app/controllers/commentController/comment.service';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-write-a-comment',
  templateUrl: './write-a-comment.component.html',
  styleUrls: ['./write-a-comment.component.css']
})
export class WriteACommentComponent implements OnInit {

  @Input() post: Post | undefined;
  image = "assets/images/profilePicture.png";
  commentForm = new FormGroup ({
    content: new FormControl('')
  })


  constructor(private commentService: CommentService) { }

  ngOnInit(): void {  }

  writeComment() {
    let userString = sessionStorage.getItem('user');
    if (userString && this.post) {
      let user: User = JSON.parse(userString);
      const content = this.commentForm.value.content;
      this.commentService.writeComment(content, user, this.post).subscribe();
    }
  }

}
