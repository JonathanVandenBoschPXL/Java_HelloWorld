import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Kind } from 'src/app/models/kind.model';

import { KindCardComponent } from './kind-card.component';

describe('KindCardComponent', () => {
  let component: KindCardComponent;
  let fixture: ComponentFixture<KindCardComponent>;
  let kind: Kind;

  beforeEach(async () => {
    kind = new Kind(0, '', '', '');
    await TestBed.configureTestingModule({
      declarations: [KindCardComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(KindCardComponent);
    component = fixture.componentInstance;
    component.kind = kind;
    fixture.detectChanges();
  });
  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
