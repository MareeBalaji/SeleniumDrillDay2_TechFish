Feature: Customer login and Transfers Fund


  Scenario: Login to TechFish Bank
    Given Launch Browser and Get the Base URL
    When User Inputs the username and password
    And User clicks on Login button
    Then Able to Successfuly login


  Scenario: Valid Payee
    Given the user is on Fund Transfer Page
    When he enters "Test" as recipient name
    And he enters "100" as amount
    And he Submits request for Fund Transfer
    Then ensure the fund transfer is complete with "100 transferred to Test successfully!!" message
