Feature: Admin issue or remove books


Background:

Given Admin is on login page
When Admin gives "lakshmi@gmail.com", "lakshmi"
Then Admin should be logged in


@Issue
Scenario: Admin should  be able to isuue books

When BooId and UserId are given 101, 111
Then Book Issued Successfully

@Remove
Scenario: Admin should  be able to remove books


When BooId given 101
Then Book removed Successfully