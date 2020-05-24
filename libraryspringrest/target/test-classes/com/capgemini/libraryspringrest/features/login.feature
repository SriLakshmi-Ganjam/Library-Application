Feature: Library Operations

#Scenario Outline: User login with valid credentials 
#
#Given User is on login page
#When User gives <emailId>, <password> 
#Then User should be logged in
#
#Examples:
#
#|emailId|password|
#|"sri@gmail.com"|"lakshmi"|
#|"lakshmi@gmail.com"|"lakshmi"|


Scenario Outline: User Registartion

Given Admin is on Registartion page
When Admin gives User Details <id>, <name>, <emailId>, <password>, <role>
Then User Registered Successfully

Examples:

|id|name|emailId|password|role|
|301|"sri"|"durga@gmail.com"|"durga1234"|"user"|
|302|"sai"|"saidurga@gmail.com"|"sai1234"|"user"|
