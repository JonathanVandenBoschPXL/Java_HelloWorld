import {Component, OnInit} from '@angular/core';
import {Situering} from "../../models/situering.model";
import {FormBuilder} from "@angular/forms";
import {TrajectService} from "../../services/traject.service";

@Component({
  selector: 'app-situeringpagina',
  templateUrl: './situeringpagina.component.html',
  styleUrls: ['./situeringpagina.component.css']
})
export class SitueringpaginaComponent implements OnInit {
  situering: Situering = new Situering('', '');
  validForm: boolean = false;

  constructor(private _formBuilder: FormBuilder, private trajectService: TrajectService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.trajectService.currentTraject.situering = this.situering;
  }

  validInput() {
    this.situering.talenten = this.situering.talenten.trim();
    this.situering.kwetsbaarheden = this.situering.kwetsbaarheden.trim();
    this.validForm = this.situering.talenten.length >= 10 && this.situering.kwetsbaarheden.length >= 10;
  }

}
