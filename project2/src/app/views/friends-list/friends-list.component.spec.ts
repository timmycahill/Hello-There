import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FriendsService } from 'src/app/controllers/friendController/friend.service';

import { FriendsListComponent } from './friends-list.component';

describe('FriendsListComponent', () => {
  let component: FriendsListComponent;
  let fixture: ComponentFixture<FriendsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FriendsService],
      declarations: [FriendsListComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
