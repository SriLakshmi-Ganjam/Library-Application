import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../library.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {RoutingGuardService } from '../routing-guard.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error: String;
  message: String;
  constructor( private routingGuardService: RoutingGuardService ,private route: ActivatedRoute, private libraryService: LibraryService, private router: Router) { }

  ngOnInit(): void {
  }
  loginUser(form: NgForm) {
    this.libraryService.postLogin(form.value).subscribe(response => {      
      // console.log(response.libraryUsers.id);       
      if (response.error) {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);
      } else {
       this.libraryService.userId = response.libraryUsers.id;
       console.log(this.libraryService.userId);
        form.reset();
        this.routingGuardService.setTempSession();
        if (response.libraryUsers.role == 'user') {
          localStorage.setItem('userDetails', JSON.stringify(response.libraryUsers));
          localStorage.setItem('role',response.libraryUsers.role);     
               
          this.router.navigateByUrl('/showBooks');
        } else if (response.libraryUsers.role == 'admin') {
          localStorage.setItem('role',response.libraryUsers.role);
          this.router.navigateByUrl('/showBooks');
        } else {
          this.message = response.message;
        setTimeout(() => {
          this.error = null;
        }, 5000);

        }
      }


    });
  }

}