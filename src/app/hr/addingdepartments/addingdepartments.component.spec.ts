import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingdepartmentsComponent } from './addingdepartments.component';

describe('AddingdepartmentsComponent', () => {
  let component: AddingdepartmentsComponent;
  let fixture: ComponentFixture<AddingdepartmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddingdepartmentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddingdepartmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
