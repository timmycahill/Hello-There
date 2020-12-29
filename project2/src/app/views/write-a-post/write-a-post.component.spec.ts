import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PostService } from 'src/app/controllers/postController/post.service';

import { WriteAPostComponent } from './write-a-post.component';

describe('WriteAPostComponent', () => {
  let component: WriteAPostComponent;
  let fixture: ComponentFixture<WriteAPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PostService],
      declarations: [WriteAPostComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WriteAPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
