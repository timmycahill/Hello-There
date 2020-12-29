import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PostService } from 'src/app/controllers/postController/post.service';

import { ProfileFeedComponent } from './profile-feed.component';

describe('ProfileFeedComponent', () => {
  let component: ProfileFeedComponent;
  let fixture: ComponentFixture<ProfileFeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PostService],
      declarations: [ProfileFeedComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileFeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
