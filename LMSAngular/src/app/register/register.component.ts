import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { LibraryService } from '../library.service';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  message: string;
  message2: string;
mySubscription: Subscription;
error;


ngForm = new FormGroup(
  {
    name: new FormControl('',Validators.required)
  }
)


  constructor(private libraryService: LibraryService) { }

  postUser(form: NgForm){
    this.libraryService.postData(form.value).subscribe(response => {
      console.log(response);
      form.reset();
      if (!response.error) {
        this.message = 'User Added Successfully';
      } else{
        this.message2 = response.message;
      }
      setTimeout(() => {
        this.message = null;
        this.message2 = null;
      }, 5000);      
    });
  }

  ngOnInit(): void {  }

}


// //message:string;

// mySubscription:Subscription;

// constructor(private productService:ProductService) { }

// postProduct(form:NgForm){
//   this.productService.postData(form.value).subscribe(response => {
//     console.log(response);
//     form.reset();
//     if(!response.error) {
//       this.message="Product Added Successfully";
//     }
//   }, error => {
//     console.log(error);
//   });
// }
// // ngOnInit() {
// }

