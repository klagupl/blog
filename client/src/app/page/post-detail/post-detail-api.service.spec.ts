import { TestBed, inject } from '@angular/core/testing';

import { PostDetailApiService } from './post-detail-api.service';

describe('PostDetailApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PostDetailApiService]
    });
  });

  it('should be created', inject([PostDetailApiService], (service: PostDetailApiService) => {
    expect(service).toBeTruthy();
  }));
});
