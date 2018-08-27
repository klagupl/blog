import { TestBed, inject } from '@angular/core/testing';

import { NavApiServiceService } from './nav-api-service.service';

describe('NavApiServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NavApiServiceService]
    });
  });

  it('should be created', inject([NavApiServiceService], (service: NavApiServiceService) => {
    expect(service).toBeTruthy();
  }));
});
