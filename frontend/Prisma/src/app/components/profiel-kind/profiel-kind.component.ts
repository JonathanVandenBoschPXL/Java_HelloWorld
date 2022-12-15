import {Component, OnInit} from '@angular/core';
import {KindProfiel} from "../../models/KindProfiel";
import {KindService} from "../../services/kind.service";
import {Observable} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-profiel-kind',
  templateUrl: './profiel-kind.component.html',
  styleUrls: ['./profiel-kind.component.css']
})
export class ProfielKindComponent implements OnInit {
  kindProfiel$!: Observable<KindProfiel>;
  kindData!: KindProfiel;
  notification: number = 1;
  kindId: string = '';
  //tijdelijk user 1 -> later dynamisch maken
  userId = this.tokenService.getUserId();

  constructor(private router: Router, private route: ActivatedRoute, private kindService: KindService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.kindId = this.route.snapshot.params['kindId'];
    sessionStorage.setItem('kindId', this.kindId)
    this.kindProfiel$ = this.kindService.getKindProfiel(this.kindId);
    this.kindProfiel$.subscribe(data =>{this.kindData = data})
  }
}
