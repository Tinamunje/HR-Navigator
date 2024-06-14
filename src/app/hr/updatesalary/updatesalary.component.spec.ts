import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatesalaryComponent } from './updatesalary.component';

describe('UpdatesalaryComponent', () => {
  let component: UpdatesalaryComponent;
  let fixture: ComponentFixture<UpdatesalaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdatesalaryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdatesalaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
