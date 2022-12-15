import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Contact } from '../models/contact.model';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) {
   }

   verzendContactEmail(contact: Contact): Observable<any> {
    return this.http.post(environment.apiUrl + "contact", contact, {observe: 'response'});
   }
}
