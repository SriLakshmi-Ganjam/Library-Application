import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {RoutingGuardService } from './routing-guard.service';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuardGuard implements CanActivate {

constructor(private routingGuardService: RoutingGuardService){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.routingGuardService.isAdminLoggedin()){
        return true;
      }else{
        return false;
      }
    
  }
  
}
