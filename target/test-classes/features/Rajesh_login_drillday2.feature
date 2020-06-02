@smoke
Feature: Sign up and Login to TechFish Bank
 
  @tag1
  Scenario: Sign up into Bank site
    Given Open bank application and click on signup button_Rajesh
    When User enters the personal details and click on register button
    Then User registration will be successful
 
  @tag2
  Scenario: Sign in into Bank site
    Given User reopens the bank application with the URL_Rajesh
    When User enters the login credentials_Rajesh
    Then User login will be successful