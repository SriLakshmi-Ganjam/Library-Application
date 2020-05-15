import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { NgForm } from '@angular/forms';
import { LibraryService } from '../library.service';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
  message: string;
  message2:string

  mySubscription: Subscription;
  userRequests;

constructor(private libraryService: LibraryService) {
  this.placedRequests();
 
 }

placedRequests(){
  this.libraryService.BooksTaken().subscribe(response => {
    console.log(response);
    
    if (!response.error) {
      // this.message = 'Request Placed Successfully';
      this.userRequests =response.requestList;
    }else{
      this.message2 = response.message;
    }
    setTimeout(() => {
      this.message = null;
      this.message2 = null;
    }, 5000);      
  });
}

postRet(userRequests){

  this.libraryService.postReturn(userRequests).subscribe(response => {
    console.log(response);
    
    if (!response.error) {
      this.placedRequests();
      this.message = 'Returned To Admin Successfully';
    }else{
      this.message2 = response.message;
    }
    setTimeout(() => {
      this.message = null;
      this.message2 = null;
    }, 5000);      
  });

  this.placedRequests();
}
    ngOnInit(): void {  }

}
