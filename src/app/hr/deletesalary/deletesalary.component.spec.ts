import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletesalaryComponent } from './deletesalary.component';

describe('DeletesalaryComponent', () => {
  let component: DeletesalaryComponent;
  let fixture: ComponentFixture<DeletesalaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DeletesalaryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeletesalaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
