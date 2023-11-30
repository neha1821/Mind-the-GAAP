import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequeRequestComponent } from './cheque-request.component';

describe('ChequeRequestComponent', () => {
  let component: ChequeRequestComponent;
  let fixture: ComponentFixture<ChequeRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChequeRequestComponent]
    });
    fixture = TestBed.createComponent(ChequeRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
