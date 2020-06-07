import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { LibraryService } from '../library.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {

  message: string;

  mySubscription: Subscription;
  requests;
  books;
  searchText;
  fieldName = "requestId";
constructor(private libraryService: LibraryService) {
  this.getRequestedBooks();
  // this.books = libraryService.getBooks();
}

getRequestedBooks(){
  this.libraryService.getReqestedBooks().subscribe(response => {
   console.log(response);
   this.requests = response.requestList;
 }, error => {
   console.log(error);
 })
}

  ngOnInit(): void {
  }

}
