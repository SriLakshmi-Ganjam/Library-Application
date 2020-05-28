Feature: User Registration

Scenario Outline: Registration with given details

Given User is on registration page
When User gave <userId> , <userName>, <userEmailId>, <userPassword>
Then User should be <status>

Examples:

|userId|userName|userEmailId|userPassword|status|
|123|"sri"|"sri@gmail.com"|"sri1234"|"registered"|
|123|"sri"|"sri@gmail.com"|"sri1234"|"User Already Exists"|