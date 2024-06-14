import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListsalaryComponent } from './listsalary.component';

describe('ListsalaryComponent', () => {
  let component: ListsalaryComponent;
  let fixture: ComponentFixture<ListsalaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListsalaryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListsalaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
