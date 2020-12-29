import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UserService } from 'src/app/controllers/userController/user.service';

import { ProfileInformationComponent } from './profile-information.component';

describe('ProfileInformationComponent', () => {
  let component: ProfileInformationComponent;
  let fixture: ComponentFixture<ProfileInformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [UserService],
      declarations: [ProfileInformationComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
