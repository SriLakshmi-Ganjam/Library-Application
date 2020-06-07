$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("admin.feature");
formatter.feature({
  "line": 2,
  "name": "After Admin Login he performs Operations like addUser, addBook, deleteBook, issueBook, receiveBook",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 14,
  "name": "User Registartion",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@register"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "Admin is on Registartion page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Admin gives User Details \u003cname\u003e, \u003cemailId\u003e, \u003cpassword\u003e, \u003crole\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User Registered Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 20,
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
      "line": 22,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion;;1"
    },
    {
      "cells": [
        "\"ramyaa\"",
        "\"ramyaa@gmail.com\"",
        "\"rama234\"",
        "\"user\""
      ],
      "line": 23,
      "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 14259360700,
  "status": "passed"
});
formatter.background({
  "line": 4,
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
  "duration": 6702081600,
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
  "duration": 1377357600,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "duration": 37700,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "User Registartion",
  "description": "",
  "id": "after-admin-login-he-performs-operations-like-adduser,-addbook,-deletebook,-issuebook,-receivebook;user-registartion;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@register"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "Admin is on Registartion page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Admin gives User Details \"ramyaa\", \"ramyaa@gmail.com\", \"rama234\", \"user\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User Registered Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Registartion_page()"
});
formatter.result({
  "duration": 3293426900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ramyaa",
      "offset": 26
    },
    {
      "val": "ramyaa@gmail.com",
      "offset": 36
    },
    {
      "val": "rama234",
      "offset": 56
    },
    {
      "val": "user",
      "offset": 67
    }
  ],
  "location": "AdminSteps.admin_gives_User_Details(String,String,String,String)"
});
formatter.result({
  "duration": 24645374500,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#name\"}\n  (Session info: chrome\u003d83.0.4103.97)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027LAPTOP-0LHA4339\u0027, ip: \u0027192.168.43.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.97, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\SRILAK~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:4475}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 732279758417a11be5e579870f9979ba\n*** Element info: {Using\u003did, value\u003dname}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:319)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:365)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:311)\r\n\tat com.capgemini.lmsbdd.stepdefinitions.AdminSteps.admin_gives_User_Details(AdminSteps.java:73)\r\n\tat ✽.When Admin gives User Details \"ramyaa\", \"ramyaa@gmail.com\", \"rama234\", \"user\"(admin.feature:17)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminSteps.user_Registered_Successfully()"
});
formatter.result({
  "status": "skipped"
});
});