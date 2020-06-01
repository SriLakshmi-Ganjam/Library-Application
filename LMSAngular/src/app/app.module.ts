import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutComponent } from './about/about.component';
import { HeaderComponent } from './header/header.component';
import { AddBookComponent } from './add-book/add-book.component';
import { ShowUsersComponent } from './show-users/show-users.component';
import { ShowBooksComponent } from './show-books/show-books.component';
import { RequestComponent } from './request/request.component';
import { ShowRequestsComponent } from './show-requests/show-requests.component';
import { IssueComponent } from './issue/issue.component';
import { UpdateComponent } from './update/update.component';
import { SearchBookPipe } from './search-book.pipe';
import { SearchUserPipe } from './search-user.pipe';
import { SearchRequestPipe } from './search-request.pipe';
import { ReturnedBooksComponent } from './returned-books/returned-books.component';
import { LibraryHistoryComponent } from './library-history/library-history.component';
import { UserHistoryComponent } from './user-history/user-history.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ContactUsComponent,
    AboutComponent,
    HeaderComponent,
    AddBookComponent,
    ShowUsersComponent,
    ShowBooksComponent,
    RequestComponent,
    ShowRequestsComponent,
    IssueComponent,
    UpdateComponent,
    SearchBookPipe,
    SearchUserPipe,
    SearchRequestPipe,
    ReturnedBooksComponent,
    LibraryHistoryComponent,
    UserHistoryComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
