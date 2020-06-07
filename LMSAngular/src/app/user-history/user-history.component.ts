import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../library.service';

@Component({
  selector: 'app-user-history',
  templateUrl: './user-history.component.html',
  styleUrls: ['./user-history.component.css']
})
export class UserHistoryComponent implements OnInit {
  userHistory;
  message:string
  searchText;
  fieldName = "requestId";
  constructor(private libraryService:LibraryService) { }

  ngOnInit(): void {
    this.userBooksHistory();
  }

  userBooksHistory() {
    this.libraryService.getUserHistory().subscribe(response => {
      console.log(response);

      if (!response.error) {
        this.userHistory = response.historyList;
      } else {
        this.message = response.message;
      }
      setTimeout(() => {
        this.message = null;

      }, 5000);
    });
  }


}
