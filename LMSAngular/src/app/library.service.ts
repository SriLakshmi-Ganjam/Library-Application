import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  lmsUrl = "http://localhost:8080/libraryspringrest/";
  userId ;

  constructor(private http: HttpClient) {
    
   }

  postData(user) {
    return this.http.post<any>(`${this.lmsUrl}addUser`, user);
  }

  postBook(addBook) {
    return this.http.post<any>(`${this.lmsUrl}addBook`, addBook);
  }

  getData() {
    return this.http.get<any>(`${this.lmsUrl}getAllUsers`);
  }

  getBooks() {
    return this.http.get<any>(`${this.lmsUrl}getAllBooks`);
  }

  postReq(request) {
    console.log(request,this.getUserId());
    // return null;
    return this.http.post<any>(`${this.lmsUrl}requestBook/${this.getUserId()}`, request);
  }

  getReq(){
    return this.http.get<any>(`${this.lmsUrl}getAllRequests`)
  }

  postIssue(issue){
    return this.http.post<any>(`${this.lmsUrl}issueBook`, issue);
  }

  postReturn(ret){
    return this.http.post<any>(`${this.lmsUrl}returnBook`, ret);
  }

  postReceive(receive){
    return this.http.post<any>(`${this.lmsUrl}receiveBook`, receive);
  }

  postSearch(search){
    return this.http.post<any>(`${this.lmsUrl}searchBook`, search);
  }

  postLogin(login){
    return this.http.post<any>(`${this.lmsUrl}login`, login);
  }

  // 



  deleteBook(book) {
   
    return this.http.delete<any>(`http://localhost:8080/libraryspringrest/deleteBook/${book.isbn}`);
}


postUpdateBoook(book){
  return this.http.post<any>(`${this.lmsUrl}updateBook`, book);
  }


  

  getReqestedBooks(){
    return this.http.get<any>(`${this.lmsUrl}getReqBooks`);

  }

  BooksTaken(){
    return this.http.get<any>(`${this.lmsUrl}userReq/${this.getUserId()}`); 
  }

  getReturnedBooks(){
    return this.http.get<any>(`${this.lmsUrl}getReturnedBooks`);
  }

isAdmin(){
  var role =  localStorage.getItem('role');
  if(role == 'admin')
  return true;
  else
  return false;
}
isUser(){
  var role =  localStorage.getItem('role');
  if(role == 'user')
  return true;
  else
  return false;
}

isLoggedIn(){
  var role = localStorage.getItem('role');
  if(role == 'user' || role == 'admin'){
    return true;
  }else{
    return false;
  }
}

isNotLoggedIn(){
  var role = localStorage.getItem('role');
  if(role != 'user' && role != 'admin'){
    return true;
  }else{
    return false;
  }
}

getUserId(){
  var user = JSON.parse(localStorage.getItem('userDetails'));

  return user.id;
}

}
