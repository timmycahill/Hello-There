import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { PostService } from 'src/app/controllers/postController/post.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-write-a-post',
  templateUrl: './write-a-post.component.html',
  styleUrls: ['./write-a-post.component.css']
})
export class WriteAPostComponent implements OnInit {

  image = "assets/images/profilePicture.png";
  postForm = new FormGroup ({
    content: new FormControl('')
  })

  constructor(private postService: PostService, private router: Router) { }

  ngOnInit(): void { }

  writePost() {
    let userString = sessionStorage.getItem('user');
    if (userString) {
      let user: User = JSON.parse(userString);
      const content = this.postForm.value.content;
      this.postService.writePost(content, user).subscribe();
    }
  }

}