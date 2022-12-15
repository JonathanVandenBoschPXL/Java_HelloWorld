import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DomeinIndicatieComponent } from './domein-indicatie.component';

describe('DomeinIndicatieComponent', () => {
  let component: DomeinIndicatieComponent;
  let fixture: ComponentFixture<DomeinIndicatieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DomeinIndicatieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DomeinIndicatieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
