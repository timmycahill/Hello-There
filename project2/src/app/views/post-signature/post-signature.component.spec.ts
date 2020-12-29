import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostSignatureComponent } from './post-signature.component';

describe('PostSignatureComponent', () => {
  let component: PostSignatureComponent;
  let fixture: ComponentFixture<PostSignatureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostSignatureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostSignatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
