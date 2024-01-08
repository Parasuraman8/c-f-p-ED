import { Injectable } from '@angular/core';
import { UrlSegment } from '@angular/router';

@Injectable({
  providedIn: 'root',
})

export class credential {
  private tokenKey = 'token';
  private roleKey = 'role';
  private isLogin = "isLogin";
  private username = "username";
  constructor() {}

  setTokenAndRole(data: any): void {
    localStorage.setItem(this.tokenKey, data.jwtToken);
    localStorage.setItem(this.roleKey, data.edRolesEntities[0].role);
    localStorage.setItem(this.username,data.username);
  }

  getUsername() : string |null  {
    return localStorage.getItem(this.username);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  getRole(): string | null {
    return localStorage.getItem(this.roleKey);
  }

  removeTokenAndRole() {
    localStorage.removeItem(this.tokenKey);
    localStorage.removeItem(this.roleKey);
    localStorage.removeItem(this.username);
  }

  setLogin(res:Boolean) : void {
    localStorage.setItem(this.isLogin,res.toString());
  }

  getLogin(): Boolean | null {
    const islog = localStorage.getItem(this.isLogin);
    return islog !== null? JSON.parse(islog):null;
  }


}
