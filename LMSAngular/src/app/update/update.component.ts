import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../library.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  message: String;
  updateBook;
  isAvailable: boolean;
  isbn: Number;
  authourName: String;
  bookTitle : String;
  price: Number;

  

  constructor(private activatedRoute: ActivatedRoute, private libraryService: LibraryService ) {
    this.activatedRoute.queryParams.subscribe(data => {
      console.log('Book To be Updated', data);
      this.updateBook = data;
      this.isAvailable = data.isAvailable;

    });
  }


  ngOnInit(): void {
    this.isbn = this.updateBook.isbn;
    this.isAvailable = this.updateBook.isAvailable;
    this.authourName = this.updateBook.authourName;
    this.bookTitle = this.updateBook.bookTitle;
    this.price = this.updateBook.price;
    


  }


  postUpdate(form: NgForm){
    this.libraryService.postUpdateBoook(form.value).subscribe(response => {
      console.log(response);
      
      
      if (!response.error) {
        this.message = 'Book Updated Successfully';
        
      }
    }, error => {
      console.log(error);
    });
  
  }

}







// class Book {
//   isbn: Number;
//   bookName: String;
//   bookTitle : String;
//   price: Number;
//   isAvailable: boolean;





// }
