import {Situering} from "./situering.model";
import {Groeipunten} from "./groeipunten.model";

export class Traject {
  situering: Situering;
  groeipunten: Groeipunten;


  constructor(situering: Situering, groeipunten: Groeipunten) {
    this.situering = situering;
    this.groeipunten = groeipunten;
  }

}
