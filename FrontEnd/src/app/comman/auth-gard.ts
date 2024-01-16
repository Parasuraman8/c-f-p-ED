import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { loginservice } from '../service/loginservice';
import { LoginServiceService } from '../service/login-service.service';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
  })
export class AuthGard implements CanActivate {

    constructor(

        private service : LoginServiceService,
        private router : Router

    ) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
      if(this.service.isAuthenticated){
        return true;
      } else {
        this.router.navigate(['/home']);
        return false;//false
      }
  }
}
