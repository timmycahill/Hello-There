import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CommentService } from 'src/app/controllers/commentController/comment.service';

import { WriteACommentComponent } from './write-a-comment.component';

describe('WriteACommentComponent', () => {
  let component: WriteACommentComponent;
  let fixture: ComponentFixture<WriteACommentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CommentService],
      declarations: [WriteACommentComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WriteACommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
