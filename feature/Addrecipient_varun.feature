Feature: Add Recipient In the TechFish Bank
  
  @Varun1
  Scenario: Login into a TechFish Bank website_varun
  	Given User open the URL
    When User enters the username and password and add the Add Recipient 
    Then Recipient Information successfully Created. 
    

	  @Varun2
 	  Scenario: User checks the List of Recipient_varun1
    Given user click on the particular recipient name 
    When user Validate the data 
    Then All data correct is created successfully under the recipient list

    
