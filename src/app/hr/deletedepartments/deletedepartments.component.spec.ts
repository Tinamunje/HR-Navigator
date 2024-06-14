import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletedepartmentsComponent } from './deletedepartments.component';

describe('DeletedepartmentsComponent', () => {
  let component: DeletedepartmentsComponent;
  let fixture: ComponentFixture<DeletedepartmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DeletedepartmentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeletedepartmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
