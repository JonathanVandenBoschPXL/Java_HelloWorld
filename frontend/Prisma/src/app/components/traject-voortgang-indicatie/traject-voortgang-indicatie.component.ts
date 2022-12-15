import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-traject-voortgang-indicatie',
  templateUrl: './traject-voortgang-indicatie.component.html',
  styleUrls: ['./traject-voortgang-indicatie.component.css']
})
export class TrajectVoortgangIndicatieComponent implements OnInit {
  @Input() huidigePlaats!: string;
  kindId!: string;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.huidigePlaats = this.router.url;
    this.kindId = JSON.parse(sessionStorage.getItem('kindId')!);
  }
  annuleren(){
    sessionStorage.clear();
  }

}
