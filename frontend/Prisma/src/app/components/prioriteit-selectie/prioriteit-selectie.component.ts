import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Traject} from "../../models/traject.model";
import {TrajectService} from "../../services/traject.service";
import {Subfunctie} from "../../models/subfunctie.model";
import {AntwoordResponse} from "../../models/TrajectResponseModels/antwoord-response.model";

@Component({
  selector: 'app-prioriteit-selectie',
  templateUrl: './prioriteit-selectie.component.html',
  styleUrls: ['./prioriteit-selectie.component.css']
})
export class PrioriteitSelectieComponent implements OnInit {
  @Input() subfunctie!: string;
  @Output() luisterNaarClick: EventEmitter<any> = new EventEmitter();
  functieAntwoorden!: Object;
  dataTraject!: Traject;
  divStyle!: string;


  constructor(private trajectService: TrajectService) {
  }

  ngOnInit(): void {
    this.dataTraject = this.trajectService.currentTraject;
    this.vindSubFunctie();
    this.divStyle = "div-default";
  }

  vindSubFunctie() {
    if (this.subfunctie == "Centrale Coherentie") {
      this.functieAntwoorden = this.dataTraject.groeipunten.mentaleFunctie.centraleCoherentie.antwoorden;
    } else if (this.subfunctie == "Executieve Functie") {
      this.functieAntwoorden = this.dataTraject.groeipunten.mentaleFunctie.executieveFuncties.antwoorden;
    } else if (this.subfunctie == "Theory of Mind") {
      this.functieAntwoorden = this.dataTraject.groeipunten.mentaleFunctie.theoryOfMind.antwoorden;
    } else if (this.subfunctie == "Socio-emotionele ontwikkeling") {
      this.functieAntwoorden = this.dataTraject.groeipunten.mentaleFunctie.socioEmotioneleOntwikkeling.antwoorden;
    } else if (this.subfunctie == "Sensorische Functies") {
      this.functieAntwoorden = this.dataTraject.groeipunten.sensorischeFunctie.antwoorden;
    } else if (this.subfunctie == "Bewegingssysteem en aan beweging verwante functies") {
      this.functieAntwoorden = this.dataTraject.groeipunten.bewegingsFunctie.antwoorden;
    }
  }

  returnAntwoordDescription(key: string) {
    let map = new Map();
    //CC
    map.set('gerichtOpDetail', 'Gericht op details');
    map.set('moeizaamGeheelZien', 'Moeizaam het geheel zien');
    map.set('vaardighedenContextAfhankelijk', 'Vaardigheden zijn contextafhankelijk');
    //EF
    map.set('responsinhibitie', 'Responsinhibitie');
    map.set('werkgeheugen', 'Werkgeheugen');
    map.set('emotieRegulatie', 'Emotie-regulatie');
    map.set('volgehoudenAandacht', 'Volgehouden aandacht');
    map.set('taakinitiatie', 'Taakinitiatie');
    map.set('planning', 'Planning');
    map.set('organisatie', 'Organisatie');
    map.set('timemanagement', 'Timemanagement');
    map.set('doelgerichtHandelen', 'Doelgericht handelen');
    map.set('flexibiliteit', 'Flexibiliteit');
    map.set('metacognitie', 'Metacognitie');
    //ToM
    map.set('letterlijkBegrijpenTaal', 'Letterlijk begrijpen van taal');
    map.set('moeitePerspectiefname', 'Moeite met perspectiefname');
    //Socio
    map.set('persoonlijkheid', 'Persoonlijkheid');
    //Sensorisch
    map.set('overprikkeling', 'Overprikkeling');
    map.set('onderprikkeling', 'Onderprikkeling');
    map.set('visueleDenkers', 'Meer frequent visuele denkers en sterk in het herkennen van patronen');
    //Beweging
    map.set('motorischeVaardigheden', 'Beperkte grove of fijn motorische vaardigheden');
    map.set('spierspanning', 'Hoge spierspanning – houterig bewegen – tenengang');
    map.set('coordinatievermogen', 'Beperkte coördinatievermogen bij motorische handelingen');

    return map.get(key)
  }

  click(e: Event): void {
    if (this.divStyle === "div-default") {
      this.divStyle = "div-click";
    } else {
      this.divStyle = "div-default"
    }
    this.luisterNaarClick.emit();
  }
}
