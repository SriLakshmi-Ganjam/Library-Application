Feature: After Admin Login he performs Operations like addUser, addBook, deleteBook, issueBook, receiveBook 

#Scenario Outline: User login with valid credentials 

Background:

Given Admin is on login page
When Admin gives "sri@gmail.com", "lakshmi" 
Then Admin should be logged in


Scenario Outline: User Registartion

Given Admin is on Registartion page
When Admin gives User Details <name>, <emailId>, <password>, <role>
Then User Registered Successfully

Examples:

|name|emailId|password|role|
|"samanthaA"|"samanthaA@gmail.com"|"samantha1"|"user"|


Scenario Outline: Adding New Book to Library

Given Admin is on Add Book page
When Admin gives Book Details  <bookTitle>, <authourName>, <price>
Then Book Added Successfully

Examples:

|bookTitle|authourName|price|
|"prathusha"|"samantha"|1000|


Scenario Outline: Deleting a Book

Given Admin is on Delete Book page
When Admin gives Book Id <isbn>
Then Book Removed From Library Successfully

Examples:

|isbn|
|93|


Scenario Outline: Issuing a Book

Given Admin is on Issue Book page
When Admin gives valid Request Id to Issue <requestId>
Then Book Issued Successfully

Examples:

|requestId|
|98|


Scenario Outline: Receiving a Book

Given Admin is on Receive Book page
When Admin gives valid Request Id to Receive <requestId>
Then Book Received Successfully

Examples:

|requestId|
|92|