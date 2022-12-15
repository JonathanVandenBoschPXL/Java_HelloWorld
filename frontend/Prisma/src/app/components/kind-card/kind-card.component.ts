import { Component, Input, OnInit } from '@angular/core';
import { Kind } from 'src/app/models/kind.model';

@Component({
  selector: 'app-kind-card',
  templateUrl: './kind-card.component.html',
  styleUrls: ['./kind-card.component.css']
})
export class KindCardComponent {
  @Input() kind!:Kind;

}
