import { Injectable } from '@angular/core';
import { NodeWithI18n } from '@angular/compiler';
import { Key } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class RoutingGuardService {

  constructor() { }

  setTempSession(){
    var value = {
      isLoggedIn : true,
      Expiry: Date.now() + 3000000
    }
    localStorage.setItem("TempSession",JSON.stringify(value));
  }

  isLoggedIn(){
    var key = localStorage.getItem("TempSession");
    var value = JSON.parse(key);
    if((value!=null) && (value.isLoggedIn)!=null){
      if(value.Expiry > Date.now()){
        return true;
      }else{
        return false;
      }

    }
    else{
      return false;
    }
  }

  isAdminLoggedin(){

    var role = localStorage.getItem('role');
    if((role =='admin') && this.isLoggedIn())
    return true;
    else
    return false;

  }

  isUserLoggedin(){
    var role = localStorage.getItem('role');
    if((role == 'user') && this.isLoggedIn())
    return true;
    else
    return false;

  }

}
