
Feature: After Admin Login he performs Operations like addUser, addBook, deleteBook, issueBook, receiveBook 

Background:


Given Admin is on login page
When Admin gives "sri@gmail.com", "lakshmi" 
Then Admin should be logged in

Scenario: User login with valid credentials 

@register			
Scenario Outline: User Registartion

Given Admin is on Registartion page
When Admin gives User Details <name>, <emailId>, <password>, <role>
Then User Registered Successfully

Examples:

|name|emailId|password|role|
|"ramyaa"|"ramyaa@gmail.com"|"rama234"|"user"|


@addBook
Scenario Outline: Adding New Book to Library

Given Admin is on Add Book page
When Admin gives Book Details  <bookTitle>, <authourName>, <price>
Then Book Added Successfully

Examples:

|bookTitle|authourName|price|
|"Adhunika Bharatam"|"Seshendra Sharma"|1000|



@showBooks
Scenario: Get All Books

Given Admin is on show all books page
Then Books Has found successfully

@showUsers
Scenario: Get All Users

Given Admin is on show all Users page
Then Users Has found successfully

@showRequests
Scenario: Get All Requests

Given Admin is on show all Requests page
Then Requests Has found successfully

@deleteBook
Scenario Outline: Deleting a Book

Given Admin is on Delete Book page
When Admin gives Book Id <isbn>
Then Book Removed From Library Successfully

Examples:

|isbn|
|93|

@issue
Scenario Outline: Issuing a Book

Given Admin is on Issue Book page
When Admin gives valid Request Id to Issue <requestId>
Then Book Issued Successfully

Examples:

|requestId|
|98|

@receive
Scenario Outline: Receiving a Book

Given Admin is on Receive Book page
When Admin gives valid Request Id to Receive <requestId>
Then Book Received Successfully

Examples:

|requestId|
|92|
