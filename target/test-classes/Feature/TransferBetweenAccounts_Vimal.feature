@All
Feature: Title of your feature
  I want to use this template for my feature file

  Background: 
    Given Launch the browser_Vimal
    When Navigate to the URL_Vimal

  @tag1
  Scenario Outline: Fund Tranfer Between Primary Account to Savings Account
    Given User enters the credentials and login to the application"<userdata>"_Vimal
    When Navigate to transfer between own accounts page_Vimal
    And User selects Primary to Savings transfer_Vimal
    Then Fund Transfer is succesfull_Vimal

    Examples: 
      | userdata |
      |        1 |
      |        2 |
      |        3 |
      |        4 |
      |        5 |

  @tag2
  Scenario Outline: Fund Tranfer Between Savings Account to Primary Account
    Given User enters the credentials and login to the application"<userdata1>"_Vimal
    When Navigate to transfer between own accounts page_Vimal
    And User selects Savings to Primary transfer_Vimal
    Then Fund Transfer is succesfull_Vimal

    Examples: 
      | userdata1 |
      |         6 |
      #|         7 |

  @tag3
  Scenario Outline: Fund Tranfer Between Primary Account to Savings Account with a invalid amount
    Given User enters the credentials and login to the application"<userdata2>"_Vimal
    When Navigate to transfer between own accounts page_Vimal
    And User selects Primary to Savings transfer and enters a invalid amount_Vimal
    Then Fund Transfer is should be rejected_Vimal

    Examples: 
      | userdata2 |
      |         8 |
