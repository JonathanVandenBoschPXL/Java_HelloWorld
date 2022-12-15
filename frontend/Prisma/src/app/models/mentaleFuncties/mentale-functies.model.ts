import {Subfunctie} from "../subfunctie.model";

export class MentaleFuncties {
  centraleCoherentie: Subfunctie;
  executieveFuncties: Subfunctie;
  theoryOfMind: Subfunctie;
  socioEmotioneleOntwikkeling: Subfunctie;


  constructor(centraleCoherentie: Subfunctie, executieveFuncties: Subfunctie, theoryOfMind: Subfunctie, socioEmotioneleOntwikkeling: Subfunctie) {
    this.centraleCoherentie = centraleCoherentie;
    this.executieveFuncties = executieveFuncties;
    this.theoryOfMind = theoryOfMind;
    this.socioEmotioneleOntwikkeling = socioEmotioneleOntwikkeling;
  }
}
