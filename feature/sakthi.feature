@All
Feature: Demmo to Register and modify TechFishBank


  @tag1
  Scenario: user register in TechFishBank_sakthi
    Given user to open the application with URL_sakthi
    When user input the Registration details_sakthi
    Then User submitted the registraion successfully_sakthi

  @tag2
  Scenario Outline: User login with valid credentials and modify the user details
    Given user login valid <username>_sakthi
    When user login with the valid <password>_sakthi
    Then User modified successfully_sakthi

    Examples: 
      | nulldemO | nulldemo1 |
      | nulldem2 | nulldemo2 |
      | nulldem3 | nulldemo3 |
      | nulldem4 | nulldemo4 |
      | nulldem5 | nulldemo5 |
