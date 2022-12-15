import {Domein} from "./domein.model";
import {User} from "../user.model";
import {SitueringResponse} from "./situering-response.model";

export class TrajectResponse {
  id: number;
  datumLaatstAangepast: string;
  domein: Domein;
  situering: SitueringResponse;
  user: User;

  constructor(id: number, datumLaatstAangepast: string, domein: Domein, situering: SitueringResponse, user: User) {
    this.id = id;
    this.datumLaatstAangepast = datumLaatstAangepast;
    this.domein = domein;
    this.situering = situering;
    this.user = user;
  }
}
