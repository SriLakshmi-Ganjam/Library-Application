import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LibraryService } from '../library.service';

@Component({
  selector: 'app-show-users',
  templateUrl: './show-users.component.html',
  styleUrls: ['./show-users.component.css']
})
export class ShowUsersComponent implements OnInit {
  message: string;

  users;
  searchText;
  fieldName = "name";
  constructor(private libraryService: LibraryService) {

    this.getUsers();
  }
  getUsers() {
    return this.libraryService.getData().subscribe(response => {
      console.log(response);
      this.users = response.userList;
    }, error => {
      console.log(error);
    })
  }
  ngOnInit(): void {
  }

}
