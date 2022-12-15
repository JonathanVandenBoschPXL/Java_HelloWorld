import {Component, OnInit} from '@angular/core';
import {KindService} from "../../services/kind.service";
import {Kind} from "../../models/kind.model";
import {catchError, Observable} from "rxjs";
import { TokenService } from 'src/app/services/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-overzicht-kinderen',
  templateUrl: './overzicht-kinderen.component.html',
  styleUrls: ['./overzicht-kinderen.component.css']
})
export class OverzichtKinderenComponent implements OnInit {
  kinderenList$!: Observable<Kind[]>;

  constructor(private kindService: KindService, private tokenService: TokenService, private router: Router) { }

  ngOnInit(): void {
    this.kinderenList$ = this.kindService.getKinderen(this.tokenService.getUserId());
  }
}
