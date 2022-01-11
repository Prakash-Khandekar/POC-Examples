import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortStudentComponent } from './sort-student.component';

describe('SortStudentComponent', () => {
  let component: SortStudentComponent;
  let fixture: ComponentFixture<SortStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
