import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileInformationComponent } from './views/profile-information/profile-information.component';
import { NavbarComponent } from './views/navbar/navbar.component';
import { HomeComponent } from './views/home/home.component';
import { ProfileComponent } from './views/profile/profile.component';
import { FriendsListComponent } from './views/friends-list/friends-list.component';
import { PostSignatureComponent } from './views/post-signature/post-signature.component';
import { CommentComponent } from './views/comment/comment.component';
import { WriteACommentComponent } from './views/write-a-comment/write-a-comment.component';
import { HomeFeedComponent } from './views/home-feed/home-feed.component';
import { ProfileFeedComponent } from './views/profile-feed/profile-feed.component';
import { WriteAPostComponent } from './views/write-a-post/write-a-post.component';
import { FriendsSidebarComponent } from './views/friends-sidebar/friends-sidebar.component';
import { LoginComponent } from './views/login/login.component';
import { SignupComponent } from './views/signup/signup.component';
import { UserService } from './controllers/userController/user.service';
import { PostService } from './controllers/postController/post.service';
import { ViewPostComponent } from './views/view-post/view-post.component';
import { PostComponent } from './views/post/post.component';
import { FriendComponent } from './views/friend/friend.component';
import { FriendsService } from './controllers/friendController/friend.service';
import { CommentService } from './controllers/commentController/comment.service';
import { LikeService } from './controllers/likeController/like.service';
import { CommentFeedComponent } from './views/comment-feed/comment-feed.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileInformationComponent,
    NavbarComponent,
    HomeComponent,
    ProfileComponent,
    FriendsListComponent,
    PostSignatureComponent,
    CommentComponent,
    WriteACommentComponent,
    HomeFeedComponent,
    ProfileFeedComponent,
    WriteAPostComponent,
    FriendsSidebarComponent,
    LoginComponent,
    SignupComponent,
    ViewPostComponent,
    PostComponent,
    FriendComponent,
    CommentFeedComponent    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],  
  providers: [
    UserService,
    PostService,
    FriendsService,
    CommentService,
    LikeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
