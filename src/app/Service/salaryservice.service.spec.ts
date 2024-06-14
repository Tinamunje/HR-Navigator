import { TestBed } from '@angular/core/testing';

import { SalaryserviceService } from './salaryservice.service';

describe('SalaryserviceService', () => {
  let service: SalaryserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalaryserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
