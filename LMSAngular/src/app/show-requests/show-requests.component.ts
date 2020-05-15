import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../library.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-requests',
  templateUrl: './show-requests.component.html',
  styleUrls: ['./show-requests.component.css']
})
export class ShowRequestsComponent implements OnInit {

  message: String;
  requests;
  issueDetails;
  searchText;
  fieldName = "requestId";

  constructor(private libraryService: LibraryService) {
    this.getReqs();
  }

  getReqs() {
    this.libraryService.getReq().subscribe(response => {
      console.log(response);
      this.requests = response.requestList;
    }, error => {
      console.log(error);
    })
  }


  issue(book) {
    this.libraryService.postIssue(book).subscribe(response => {
      console.log(response);
      this.issueDetails = response.requestInfo;
      if (response.error) {
        this.message = 'Failed To issue The Book';
      } else {
        this.getReqs();
        this.message = 'Book Issued Successfully';
      }
      setTimeout(() => {
        this.message = null;
      }, 5000);


    });
  }

  // receive(book){
  //   this.libraryService.postReceive(book).subscribe(response =>{
  //     console.log(response);
  //     this.issueDetails = response.requestInfo;
  //     if(response.error){
  //       this.message = 'Failed To issue The Book';        
  //     }else{
  //       this.message = 'Book Issued Successfully';
  //     }
  //     setTimeout(() => {
  //       this.message = null;
  //     }, 5000);      


  //   });
  // }

  ngOnInit(): void {
  }

}
