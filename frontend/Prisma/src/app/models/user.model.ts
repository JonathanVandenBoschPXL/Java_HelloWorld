import {UserRol} from "./TrajectResponseModels/user-rol";

export class User {
  rol: UserRol;

  constructor(rol: UserRol) {
    this.rol = rol;
  }
}
