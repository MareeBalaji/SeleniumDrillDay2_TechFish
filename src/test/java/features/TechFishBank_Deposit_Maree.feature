Feature: TechFishBank_Deposit

  @Maree1
  Scenario: To Validate successful Deposit to Primary Account
    Given Sigin-In TechFishBank Application and Validate Dashboard_Maree
    When Perform and Validate multiple Deposit for Primary Account_Maree
    Then Signout TechFishBank Application _Maree

  @Maree2
  Scenario Outline: To Validate successful Deposit to Savings Account
    Given Sigin-In with Multiple users "<SQLQuery>" TechFishBank Application and Validate Dashboard_Maree
    When Perform and Validate multiple Deposit "<SQLQuery>"for Savings Account_Maree
    Then Signout TechFishBank Application _Maree

    Examples: 
      | SQLQuery                                                                                  |
      | SELECT * FROM Maree where ScriptName ='SavingsDeposit' AND `Iteration`='SavingsDeposit1'; |
      | SELECT * FROM Maree where ScriptName ='SavingsDeposit' AND `Iteration`='SavingsDeposit2'; |
      | SELECT * FROM Maree where ScriptName ='SavingsDeposit' AND `Iteration`='SavingsDeposit3'; |
      | SELECT * FROM Maree where ScriptName ='SavingsDeposit' AND `Iteration`='SavingsDeposit4'; |
      | SELECT * FROM Maree where ScriptName ='SavingsDeposit' AND `Iteration`='SavingsDeposit5'; |