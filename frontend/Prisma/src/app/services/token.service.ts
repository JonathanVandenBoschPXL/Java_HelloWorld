import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  accessToken!: string;
  decodedAccessToken!: {[key: string]: string};
  static loggedIn: boolean;

  constructor() {
  }
  
  public setAccessToken(accessToken: string){
    this.accessToken = accessToken;
    TokenService.loggedIn = true;
  }

  public getAccessToken(): string{
    if(TokenService.loggedIn){
      return this.accessToken;
    }else{
      throw new Error("Not logged in!");
    }
  }

  private decodeAccessToken(){
    if(TokenService.loggedIn){
      this.decodedAccessToken = jwt_decode(this.accessToken);
    }
  }

  public getUserId(){
    this.decodeAccessToken();
    return this.decodedAccessToken['id'];
  }
}

