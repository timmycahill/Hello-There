import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FriendsService } from 'src/app/controllers/friendController/friend.service';

import { FriendsSidebarComponent } from './friends-sidebar.component';

describe('FriendsSidebarComponent', () => {
  let component: FriendsSidebarComponent;
  let fixture: ComponentFixture<FriendsSidebarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FriendsService],
      declarations: [FriendsSidebarComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendsSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
