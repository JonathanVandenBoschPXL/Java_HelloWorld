import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ContactService } from 'src/app/services/contact.service';
import { Contact } from '../../models/contact.model';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contact!: Contact;
  sent: boolean = false;

  constructor(private contactService: ContactService, private dialog: MatDialog) {
    this.contact = new Contact('', '', '', '');
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.contactService.verzendContactEmail(this.contact).subscribe(response => {
      if (response.status == 201) {
        this.sent = true;
      }
    });
  }

  openCancelDialog(): void {
    this.dialog.open(DialogComponent, {
      width: '25rem',
      data: {
        title: "Annuleer e-mail",
        content: "Weet je zeker dat je het verzenden van de e-mail wilt annuleren?",
        onNoClickButtonTitle: "Nee",
        onYesClickButtonTitle: "Ja, annuleer email",
        onYesClickFunction: this.routeToHome
      }
    });
  }

  routeToHome(router: Router): any {
    router.navigate(['/home']);
  }
}
