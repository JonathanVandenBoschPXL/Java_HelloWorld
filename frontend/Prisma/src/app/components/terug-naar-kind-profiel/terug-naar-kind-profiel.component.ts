import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-terug-naar-kind-profiel',
  templateUrl: './terug-naar-kind-profiel.component.html',
  styleUrls: ['./terug-naar-kind-profiel.component.css']
})
export class TerugNaarKindProfielComponent implements OnInit {
  kindId!: string;
  constructor() { }

  ngOnInit(): void {
    this.kindId = JSON.parse(sessionStorage.getItem('kindId')!);
  }
}
