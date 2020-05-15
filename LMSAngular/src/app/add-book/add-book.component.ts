import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { LibraryService } from '../library.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  message:string;

mySubscription:Subscription;

  constructor(private libraryService:LibraryService) { }

  postaddBook(form:NgForm){
    this.libraryService.postBook(form.value).subscribe(response => {
      console.log(response);
      form.reset();
      if(!response.error) {
        this.message="Book Added Successfully";
      }else{
        this.message = response.error
      }
      setTimeout(() => {
        this.message = null;
      }, 5000);      
    });
  }





  ngOnInit(): void {
  }

}
