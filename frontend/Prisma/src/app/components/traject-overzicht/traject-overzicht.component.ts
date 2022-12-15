import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TrajectService} from "../../services/traject.service";
import {TrajectAanwezig} from "../../models/TrajectAanwezig";
import {KindService} from "../../services/kind.service";
import {KindProfiel} from "../../models/KindProfiel";
import {ApiService} from "../../services/api.service";

@Component({
  selector: 'app-traject-overzicht',
  templateUrl: './traject-overzicht.component.html',
  styleUrls: ['./traject-overzicht.component.css']
})
export class TrajectOverzichtComponent implements OnInit {
  kind!: KindProfiel;
  trajectAanwezig!: TrajectAanwezig;
  kindId!: string;
  userId!: string;


  constructor(
    private route: ActivatedRoute, private router: Router,
    private apiService: ApiService, private trajectService: TrajectService,
    private kindService: KindService) {
  }

  ngOnInit(): void {
    this.kindId = this.route.snapshot.params['kindId'];
    this.userId = this.route.snapshot.params['userId'];
    this.checkVoorTraject(this.userId, this.kindId);
    this.getKind(this.kindId)
  }

  checkVoorTraject(userId: string, kindId: string) {
    let trajectFetch = this.apiService.checkVoorBestaandeTrajecten(userId, kindId);
    trajectFetch.subscribe(data => {
      this.trajectAanwezig = data
    });
  }

  getKind(kindId: string) {
    let kindFetch = this.kindService.getKindProfiel(kindId)
    kindFetch.subscribe(data => {
      this.kind = data
    })
  }

  maakNieuwTraject() {
    this.trajectService.maakNieuwTraject();
    this.router.navigate(['/situering']);
  }

  async laadBestaandeTrajecten() {
    await this.router.navigate(['/afgemaakttraject']);
  }

}
