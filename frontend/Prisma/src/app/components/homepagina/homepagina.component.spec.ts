import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomepaginaComponent } from './homepagina.component';

describe('HomepaginaComponent', () => {
  let component: HomepaginaComponent;
  let fixture: ComponentFixture<HomepaginaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomepaginaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomepaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
