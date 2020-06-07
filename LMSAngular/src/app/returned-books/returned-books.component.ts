import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { LibraryService } from '../library.service';

@Component({
  selector: 'app-returned-books',
  templateUrl: './returned-books.component.html',
  styleUrls: ['./returned-books.component.css']
})
export class ReturnedBooksComponent implements OnInit {

  message: string;
  message2: string;
  mySubscription: Subscription;
  returnedBooks;
  requests;
  books;
  searchText;
  fieldName = "requestId";
constructor(private libraryService: LibraryService) {
  this.getReturnedBooks();
}

getReturnedBooks(){
  this.libraryService.getReturnedBooks().subscribe(response => {
   console.log(response);
   this.requests = response.requestList;
 }, error => {
   console.log(error);
 })
}


receive(requests){
  this.libraryService.postReceive(requests).subscribe(response =>{
    console.log(response);
    this.requests = response.requestInfo;
    if(response.error){
      this.message2 = response.message;        
    }else{
      this.getReturnedBooks();
      this.message = 'Book received Successfully';
    }  
    setTimeout(() => {
      this.message = null;
      this.message2 = null;
    }, 5000);      
  });  
}



  ngOnInit(): void {
  }

}
