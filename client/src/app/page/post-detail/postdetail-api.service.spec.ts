import { TestBed, inject } from '@angular/core/testing';

import { PostdetailApiService } from './postdetail-api.service';

describe('PostdetailApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PostdetailApiService]
    });
  });

  it('should be created', inject([PostdetailApiService], (service: PostdetailApiService) => {
    expect(service).toBeTruthy();
  }));
});
