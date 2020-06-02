Feature: login to tech bank
 I want to schedule an appoinment 

  @tag1
   Scenario Outline: User login
    Given Open the URL
    When when i enter "<username>" and password as "<password>"
    Then login should be sucessfull
     Examples: 
      | username | password   |
      | labuser  | labuser@01 |
   
   
  @tag2
 Scenario: schedule an appoinment
    Given navigate to appoinment page
    When enter the appoinment details
    And enter the Appoinment details to db
    Then logout of the system
