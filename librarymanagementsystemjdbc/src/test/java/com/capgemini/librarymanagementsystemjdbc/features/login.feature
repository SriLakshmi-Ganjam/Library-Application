Feature: Admin login

Scenario Outline: Admin login with valid credentials 

Given Admin is on login page
When Admin gives <emailId>, <password> 
Then Admin should be logged in

Examples:

|emailId|password|
|"lakshmi@gmail.com"|"lakshmi"|
|"lakshmi@gmail.com"|"srifsdsf"|
|"srignjam@gmail.com"|"lakshmi"|