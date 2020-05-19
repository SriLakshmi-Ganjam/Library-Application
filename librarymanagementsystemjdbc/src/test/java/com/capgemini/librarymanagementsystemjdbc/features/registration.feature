Feature: User Registration

  Scenario Outline: User Registration with given details
    Given User is on rgistration page
    When User enters <id>, <name>, <emailId>, <password>, <role>
    Then User should be <status>

    Examples: 
      | id  | name      | emailId             | password  | role    | status                   |
      | 123 | "lakshmi" | "lakshmi@gmail.com" | "lakshmi" | "admin" | "registered Sucessfully" |
      | 123 | "lakshmi" | "lakshmi@gmail.com" | "lakshmi" | "admin" | "User already Exists"    |

      
        Scenario: User Registration with given details
    Given User is on rgistration page
    When User enters 300, "saiLakshmi", "sailakshmi@gmail.in", "sri21234", "user"
    Then User should be "user Registered"