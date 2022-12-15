import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { environment } from 'src/environments/environment';
import { Contact } from '../models/contact.model';

import { ContactService } from './contact.service';

describe('ContactService', () => {
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ContactService]
    });
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  describe('verzendContactEmail', () => {
    it('should post to backend with correct contact', () => {
      let contact: Contact = new Contact('onderwerp', 'verzender@email.com', 'dit is een emailtext', 'Naam');
      const contactService = TestBed.inject(ContactService);
      contactService.verzendContactEmail(contact).subscribe(response => {
        expect(response.status).toEqual(201);
      });
      const req = httpTestingController.expectOne(environment.apiUrl + "contact");
      req.flush('body', { status: 201, statusText: 'created' })
      httpTestingController.verify();
    })
  })
});
