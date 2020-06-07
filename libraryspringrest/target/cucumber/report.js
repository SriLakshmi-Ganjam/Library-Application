$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("admin.feature");
formatter.feature({
  "line": 1,
  "name": "After Admin Login he performs Operations like addUser, addBook, deleteBook, issueBook, receiveBook",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 12,
  "name": "User Registartion",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "Admin is on Registartion page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Admin gives User Details \u003cname\u003e, \u003cemailId\u003e, \u003cpassword\u003e, \u003crole\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "User Registered Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion;",
  "rows": [
    {
      "cells": [
        "name",
        "emailId",
        "password",
        "role"
      ],
      "line": 20,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion;;1"
    },
    {
      "cells": [
        "\"samanthaA\"",
        "\"samanthaA@gmail.com\"",
        "\"samantha1\"",
        "\"user\""
      ],
      "line": 21,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 120900,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Scenario Outline: User login with valid credentials"
    }
  ],
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Admin gives \"sri@gmail.com\", \"lakshmi\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 707431300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sri@gmail.com",
      "offset": 13
    },
    {
      "val": "lakshmi",
      "offset": 30
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 18023200,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.AdminSteps.admin_gives(AdminSteps.java:50)\r\n\tat ✽.When Admin gives \"sri@gmail.com\", \"lakshmi\"(admin.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 21,
  "name": "User Registartion",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "Admin is on Registartion page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Admin gives User Details \"samanthaA\", \"samanthaA@gmail.com\", \"samantha1\", \"user\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "User Registered Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Registartion_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "samanthaA",
      "offset": 26
    },
    {
      "val": "samanthaA@gmail.com",
      "offset": 39
    },
    {
      "val": "samantha1",
      "offset": 62
    },
    {
      "val": "user",
      "offset": 75
    }
  ],
  "location": "AdminSteps.admin_gives_User_Details(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.user_Registered_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 24,
  "name": "Adding New Book to Library",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;adding-new-book-to-library",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 26,
  "name": "Admin is on Add Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Admin gives Book Details  \u003cbookTitle\u003e, \u003cauthourName\u003e, \u003cprice\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Book Added Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 30,
  "name": "",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;adding-new-book-to-library;",
  "rows": [
    {
      "cells": [
        "bookTitle",
        "authourName",
        "price"
      ],
      "line": 32,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;adding-new-book-to-library;;1"
    },
    {
      "cells": [
        "\"prathusha\"",
        "\"samantha\"",
        "1000"
      ],
      "line": 33,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;adding-new-book-to-library;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 48800,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Scenario Outline: User login with valid credentials"
    }
  ],
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Admin gives \"sri@gmail.com\", \"lakshmi\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 31400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sri@gmail.com",
      "offset": 13
    },
    {
      "val": "lakshmi",
      "offset": 30
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 419000,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.AdminSteps.admin_gives(AdminSteps.java:50)\r\n\tat ✽.When Admin gives \"sri@gmail.com\", \"lakshmi\"(admin.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 33,
  "name": "Adding New Book to Library",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;adding-new-book-to-library;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 26,
  "name": "Admin is on Add Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Admin gives Book Details  \"prathusha\", \"samantha\", 1000",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Book Added Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Add_Book_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "prathusha",
      "offset": 27
    },
    {
      "val": "samantha",
      "offset": 40
    },
    {
      "val": "1000",
      "offset": 51
    }
  ],
  "location": "AdminSteps.admin_gives_Book_Details(String,String,int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.book_Added_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 36,
  "name": "Deleting a Book",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;deleting-a-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 38,
  "name": "Admin is on Delete Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Admin gives Book Id \u003cisbn\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "Book Removed From Library Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 42,
  "name": "",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;deleting-a-book;",
  "rows": [
    {
      "cells": [
        "isbn"
      ],
      "line": 44,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;deleting-a-book;;1"
    },
    {
      "cells": [
        "93"
      ],
      "line": 45,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;deleting-a-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 204100,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Scenario Outline: User login with valid credentials"
    }
  ],
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Admin gives \"sri@gmail.com\", \"lakshmi\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 40700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sri@gmail.com",
      "offset": 13
    },
    {
      "val": "lakshmi",
      "offset": 30
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 727300,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.AdminSteps.admin_gives(AdminSteps.java:50)\r\n\tat ✽.When Admin gives \"sri@gmail.com\", \"lakshmi\"(admin.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 45,
  "name": "Deleting a Book",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;deleting-a-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 38,
  "name": "Admin is on Delete Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Admin gives Book Id 93",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "Book Removed From Library Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Delete_Book_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "93",
      "offset": 20
    }
  ],
  "location": "AdminSteps.admin_gives_Book_Id(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.book_Removed_From_Library_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 48,
  "name": "Issuing a Book",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;issuing-a-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 50,
  "name": "Admin is on Issue Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "Admin gives valid Request Id to Issue \u003crequestId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "Book Issued Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 54,
  "name": "",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;issuing-a-book;",
  "rows": [
    {
      "cells": [
        "requestId"
      ],
      "line": 56,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;issuing-a-book;;1"
    },
    {
      "cells": [
        "98"
      ],
      "line": 57,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;issuing-a-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 37600,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Scenario Outline: User login with valid credentials"
    }
  ],
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Admin gives \"sri@gmail.com\", \"lakshmi\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 38000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sri@gmail.com",
      "offset": 13
    },
    {
      "val": "lakshmi",
      "offset": 30
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 1965200,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.AdminSteps.admin_gives(AdminSteps.java:50)\r\n\tat ✽.When Admin gives \"sri@gmail.com\", \"lakshmi\"(admin.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 57,
  "name": "Issuing a Book",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;issuing-a-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 50,
  "name": "Admin is on Issue Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 51,
  "name": "Admin gives valid Request Id to Issue 98",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "Book Issued Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Issue_Book_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "98",
      "offset": 38
    }
  ],
  "location": "AdminSteps.admin_gives_valid_Request_Id_to_Issue(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.book_Issued_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 60,
  "name": "Receiving a Book",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;receiving-a-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 62,
  "name": "Admin is on Receive Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "Admin gives valid Request Id to Receive \u003crequestId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "Book Received Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 66,
  "name": "",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;receiving-a-book;",
  "rows": [
    {
      "cells": [
        "requestId"
      ],
      "line": 68,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;receiving-a-book;;1"
    },
    {
      "cells": [
        "92"
      ],
      "line": 69,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;receiving-a-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 41800,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Scenario Outline: User login with valid credentials"
    }
  ],
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Admin gives \"sri@gmail.com\", \"lakshmi\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 680300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sri@gmail.com",
      "offset": 13
    },
    {
      "val": "lakshmi",
      "offset": 30
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 528000,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.AdminSteps.admin_gives(AdminSteps.java:50)\r\n\tat ✽.When Admin gives \"sri@gmail.com\", \"lakshmi\"(admin.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 69,
  "name": "Receiving a Book",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;receiving-a-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 62,
  "name": "Admin is on Receive Book page",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "Admin gives valid Request Id to Receive 92",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "Book Received Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Receive_Book_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "92",
      "offset": 40
    }
  ],
  "location": "AdminSteps.admin_gives_valid_Request_Id_to_Receive(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.book_Received_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("user.feature");
formatter.feature({
  "line": 1,
  "name": "After User Login he performs Operations like Request a Book and Return a book",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "User login with valid credentials",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;user-login-with-valid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User gives \u003cemailId\u003e, \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User should be logged in",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;user-login-with-valid-credentials;",
  "rows": [
    {
      "cells": [
        "emailId",
        "password"
      ],
      "line": 11,
      "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;user-login-with-valid-credentials;;1"
    },
    {
      "cells": [
        "\"padma@gmail.com\"",
        "\"padmavathi\""
      ],
      "line": 12,
      "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;user-login-with-valid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 62900,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "User login with valid credentials",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;user-login-with-valid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User gives \"padma@gmail.com\", \"padmavathi\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.user_is_on_login_page()"
});
formatter.result({
  "duration": 18251000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "padma@gmail.com",
      "offset": 12
    },
    {
      "val": "padmavathi",
      "offset": 31
    }
  ],
  "location": "UserSteps.user_gives(String,String)"
});
formatter.result({
  "duration": 2523900,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.dao.LibraryDAOImplementation.adminAuthentication(LibraryDAOImplementation.java:91)\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.UserSteps.user_gives(UserSteps.java:27)\r\n\tat ✽.When User gives \"padma@gmail.com\", \"padmavathi\"(user.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "UserSteps.user_should_be_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 15,
  "name": "Request a Book",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;request-a-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 17,
  "name": "User is on Request page",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User Requests a Book by valid User Id and Book Id \u003cuserId\u003e, \u003cbookId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User Placed a Request Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 21,
  "name": "",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;request-a-book;",
  "rows": [
    {
      "cells": [
        "userId",
        "bookId"
      ],
      "line": 23,
      "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;request-a-book;;1"
    },
    {
      "cells": [
        "63",
        "66"
      ],
      "line": 24,
      "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;request-a-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 36500,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Request a Book",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;request-a-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 17,
  "name": "User is on Request page",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User Requests a Book by valid User Id and Book Id 63, 66",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User Placed a Request Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.user_is_on_Request_page()"
});
formatter.result({
  "duration": 737300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "63",
      "offset": 50
    },
    {
      "val": "66",
      "offset": 54
    }
  ],
  "location": "UserSteps.user_Requests_a_Book_by_valid_User_Id_and_Book_Id(int,int)"
});
formatter.result({
  "duration": 4321300,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.dao.LibraryDAOImplementation.bookRequest(LibraryDAOImplementation.java:352)\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.UserSteps.user_Requests_a_Book_by_valid_User_Id_and_Book_Id(UserSteps.java:43)\r\n\tat ✽.When User Requests a Book by valid User Id and Book Id 63, 66(user.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "UserSteps.user_Placed_a_Request_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 27,
  "name": "Return a Book",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;return-a-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 29,
  "name": "User is on Return page",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "User Returns a Book by valid User Id and Book Id \u003cuserId\u003e, \u003cbookId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "User  Returned the Book Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;return-a-book;",
  "rows": [
    {
      "cells": [
        "userId",
        "bookId"
      ],
      "line": 35,
      "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;return-a-book;;1"
    },
    {
      "cells": [
        "68",
        "65"
      ],
      "line": 36,
      "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;return-a-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 124600,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Return a Book",
  "description": "",
  "id": "after-user-login-he-performs-operations-like-request-a-book-and-return-a-book;return-a-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 29,
  "name": "User is on Return page",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "User Returns a Book by valid User Id and Book Id 68, 65",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "User  Returned the Book Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.user_is_on_Return_page()"
});
formatter.result({
  "duration": 84400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "68",
      "offset": 49
    },
    {
      "val": "65",
      "offset": 53
    }
  ],
  "location": "UserSteps.user_Returns_a_Book_by_valid_User_Id_and_Book_Id(int,int)"
});
formatter.result({
  "duration": 3129900,
  "error_message": "java.lang.NullPointerException\r\n\tat com.capgemini.libraryspringrest.dao.LibraryDAOImplementation.bookReturn(LibraryDAOImplementation.java:471)\r\n\tat com.capgemini.libraryspringrest.stepdefinitions.UserSteps.user_Returns_a_Book_by_valid_User_Id_and_Book_Id(UserSteps.java:61)\r\n\tat ✽.When User Returns a Book by valid User Id and Book Id 68, 65(user.feature:30)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "UserSteps.user_Returned_the_Book_Successfully()"
});
formatter.result({
  "status": "skipped"
});
});