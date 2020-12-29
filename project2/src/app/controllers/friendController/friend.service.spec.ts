import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { FriendsService } from './friend.service';

describe('FriendsService', () => {
  let service: FriendsService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FriendsService],
    });
    service = TestBed.inject(FriendsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
