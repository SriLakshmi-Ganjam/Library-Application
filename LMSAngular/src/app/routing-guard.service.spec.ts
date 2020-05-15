import { TestBed } from '@angular/core/testing';

import { RoutingGuardService } from './routing-guard.service';

describe('RoutingGuardService', () => {
  let service: RoutingGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoutingGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
