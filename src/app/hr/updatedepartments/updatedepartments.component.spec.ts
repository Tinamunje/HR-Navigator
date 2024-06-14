import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatedepartmentsComponent } from './updatedepartments.component';

describe('UpdatedepartmentsComponent', () => {
  let component: UpdatedepartmentsComponent;
  let fixture: ComponentFixture<UpdatedepartmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdatedepartmentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdatedepartmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
