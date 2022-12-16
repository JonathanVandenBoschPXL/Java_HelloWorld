import { DebugNode, NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import { Contact } from 'src/app/models/contact.model';
import { of } from "rxjs";

import { ContactComponent } from './contact.component';
import { ContactService } from 'src/app/services/contact.service';
import { MatDialog } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';

describe('ContactComponent', () => {
  let fixture: ComponentFixture<ContactComponent>;
  let mockContactService: jasmine.SpyObj<any>;
  let mockMatDialog: jasmine.SpyObj<any>;
  let mockRouter: jasmine.SpyObj<any>;
  let contact: Contact;
  let instance: DebugNode["componentInstance"];
  beforeEach(() => {
    contact = new Contact('testonderwerp', 'verzender@test.com',
      'deze email heeft een test body', 'Test Naam');

    mockContactService = jasmine.createSpyObj(['verzendContactEmail']);
    mockMatDialog = jasmine.createSpyObj(['open']);
    mockRouter = jasmine.createSpyObj(['navigate']);

    TestBed.configureTestingModule({
      declarations: [ContactComponent],
      imports: [FormsModule],
      providers: [
        { provide: ContactService, useValue: mockContactService },
        { provide: MatDialog, useValue: mockMatDialog }
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })

    fixture = TestBed.createComponent(ContactComponent);
    instance = fixture.debugElement.componentInstance;
    instance.contact = contact;
    fixture.detectChanges();
  });

  // describe('onSubmit', () => {

  //   it('should use contactService to send email', fakeAsync(() => {
  //     mockContactService.verzendContactEmail.and.returnValue(of({ status: 201 }));

  //     instance.onSubmit();
  //     tick();

  //     expect(mockContactService.verzendContactEmail).toHaveBeenCalledWith(instance.contact);
  //   }));

  //   it('should not set sent to true when something went wrong sending the email', fakeAsync(() => {
  //     mockContactService.verzendContactEmail.and.returnValue(of({ status: 400 }));

  //     instance.onSubmit();
  //     tick();

  //     expect(instance.sent).toBeFalse();
  //   }));

  //   it('should set sent to true when getting succesful response', fakeAsync(() => {
  //     mockContactService.verzendContactEmail.and.returnValue(of({ status: 201 }));

  //     instance.onSubmit();
  //     tick();

  //     expect(instance.sent).toBeTrue();
  //   }));
  // });

  describe('openCancelDialog', () => {
    it('should open new dialogcomponent', () => {
      instance.openCancelDialog();
      expect(mockMatDialog.open).toHaveBeenCalledWith(jasmine.any(Function), jasmine.any(Object));
    })
  });

  describe('routeToHome', () => {
    it('should use passed through router to navigate to homepage', () => {
      instance.routeToHome(mockRouter);

      expect(mockRouter.navigate).toHaveBeenCalledWith(['/home']);
    })
  })

});
