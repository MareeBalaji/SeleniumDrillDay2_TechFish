@smoke
Feature: Mercury tour login

  @TC01
  Scenario: Login to mercury tour site
    Given User opens the application with the URL
    And User clicks on SignOn link
    When User inputs the valid user credentials
    And User clicks Submit button
    Then Able to successfully load the page

  @TC02
  Scenario Outline: Login to Agile project
    Given user clicks on agile project link
    When user enters the "<username>"
    And user gives the "<password>"
    And click on login button
    Then homepage is visible

    Examples: 
      | username | password |
      |     1303 | Guru99   |
