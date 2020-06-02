$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Rajesh_login_drillday2.feature");
formatter.feature({
  "line": 2,
  "name": "Sign up and Login to TechFish Bank",
  "description": "",
  "id": "sign-up-and-login-to-techfish-bank",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    }
  ]
});
formatter.scenario({
  "line": 11,
  "name": "Sign in into Bank site",
  "description": "",
  "id": "sign-up-and-login-to-techfish-bank;sign-in-into-bank-site",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "User reopens the bank application with the URL_Rajesh",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User enters the login credentials_Rajesh",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User login will be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "Login_drillday2_Rajesh.user_reopens_the_bank_application_with_the_URL_Rajesh()"
});
formatter.result({
  "duration": 15422776951,
  "status": "passed"
});
formatter.match({
  "location": "Login_drillday2_Rajesh.user_enters_the_login_credentials_Rajesh()"
});
formatter.result({
  "duration": 20666086311,
  "error_message": "java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \u0027\u003d firstuser\u0027 at line 1\r\n\tat com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)\r\n\tat com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)\r\n\tat com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)\r\n\tat com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)\r\n\tat com.mysql.cj.jdbc.ClientPreparedStatement.executeUpdateInternal(ClientPreparedStatement.java:1092)\r\n\tat com.mysql.cj.jdbc.ClientPreparedStatement.executeUpdateInternal(ClientPreparedStatement.java:1040)\r\n\tat com.mysql.cj.jdbc.ClientPreparedStatement.executeLargeUpdate(ClientPreparedStatement.java:1347)\r\n\tat com.mysql.cj.jdbc.ClientPreparedStatement.executeUpdate(ClientPreparedStatement.java:1025)\r\n\tat stepdefinition.Login_drillday2_Rajesh.user_enters_the_login_credentials_Rajesh(Login_drillday2_Rajesh.java:86)\r\n\tat ✽.When User enters the login credentials_Rajesh(features/Rajesh_login_drillday2.feature:13)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Login_drillday2_Rajesh.user_login_will_be_successful()"
});
formatter.result({
  "status": "skipped"
});
});