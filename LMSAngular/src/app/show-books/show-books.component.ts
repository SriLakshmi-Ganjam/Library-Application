import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../library.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-books',
  templateUrl: './show-books.component.html',
  styleUrls: ['./show-books.component.css']
})
export class ShowBooksComponent implements OnInit {

  message: String;
  message2: string;
  books;
  isAdminLogin: boolean;
  isUserLogin: boolean;
  request: RequestInfo;
  searchText;
  fieldName = "bookTitle";


  constructor(private libraryService: LibraryService, private router: Router) {
    this.getBooks();
    this.isAdminLogin = libraryService.isAdmin();
    this.isUserLogin = libraryService.isUser();
  }

  getBooks() {
    return this.libraryService.getBooks().subscribe(response => {
      console.log(response);
      this.books = response.bookList;
    }, error => {
      console.log(error);
    })
  }


  deleteBook(book) {
    this.libraryService.deleteBook(book).subscribe(response => {
      console.log(response);
      if (response.error) {
        this.message2 = response.message;
      } else {
        this.getBooks();
        this.message = response.message;
      }
      setTimeout(() => {
        this.message = null;
        this.message2 = null;
      }, 5000);
    });
  }

  //update
  updateBook(book) {
    this.router.navigate(['/update'], { queryParams: book });
  }

  //palce a Request   
  postReq(userRequests){

    this.libraryService.postReq(userRequests).subscribe(response => {
      console.log(response);
      
      if (!response.error) {
        this.message = 'Request Placed To Admin Successfully';
      }else{
        this.message2 = response.message;
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
class RequestInfo {
  userId: String;
  bookId: String;
}