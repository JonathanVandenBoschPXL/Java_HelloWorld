import {Component, Input, OnInit} from '@angular/core';
import {TrajectResponse} from "../../models/TrajectResponseModels/traject-response.model";

@Component({
  selector: 'app-afgemaakt-traject-card',
  templateUrl: './afgemaakt-traject-card.component.html',
  styleUrls: ['./afgemaakt-traject-card.component.css']
})

export class AfgemaaktTrajectCardComponent {
  @Input() traject!: TrajectResponse;
  functieCodes: string[] = ['b.b1', '2.b/s2', '3.b/s'];
  functieNamen: string[] = ['Mentale functies', 'Sensorische functies', 'Bewegingssysteem  en aan beweging verwante functies'];
  subfunctieNamen: string[] = ['Centrale Coherentie (CC)', 'Executieve Functies (EF)', 'Theory of Mind (ToM)', 'Socio-emotionele ontwikkeling']

}
