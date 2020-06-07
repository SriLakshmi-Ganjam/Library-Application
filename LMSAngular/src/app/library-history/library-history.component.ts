import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../library.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-library-history',
  templateUrl: './library-history.component.html',
  styleUrls: ['./library-history.component.css']
})
export class LibraryHistoryComponent implements OnInit {
  mySubscription: Subscription;
  libhistory;
  message: string;
  searchText;
  fieldName = "requestId";
  constructor(private libraryService: LibraryService) { }

  ngOnInit(): void {
    this.libraryHistory();
  }

  libraryHistory() {
    this.libraryService.getHistory().subscribe(response => {
      console.log(response);

      if (!response.error) {
        this.libhistory = response.historyList;
      } else {
        this.message = response.message;
      }
      setTimeout(() => {
        this.message = null;

      }, 5000);
    });
  }

}
