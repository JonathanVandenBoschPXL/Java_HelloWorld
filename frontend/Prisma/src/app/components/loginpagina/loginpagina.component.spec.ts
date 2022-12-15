import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginpaginaComponent } from './loginpagina.component';

describe('LoginpaginaComponent', () => {
  let component: LoginpaginaComponent;
  let fixture: ComponentFixture<LoginpaginaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginpaginaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginpaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
