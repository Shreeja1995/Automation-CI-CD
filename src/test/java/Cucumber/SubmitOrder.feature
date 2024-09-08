

Feature: Ecommerce app

Background: 
Given I landed on ecommerce page

  @Regression
  Scenario Outline: Positive testing for submitorder
  
    Given I logged in with username "<username>" and password "<password>"
    When I add the product "<productName>" to Cart
    And  checkout "<productName>" and submit the order
    Then verify "THANKYOU FOR THE ORDER." is displayed on confirmation page
    
Examples:
      | username          | password   | productName  |
      | shree@email.com   | Learning@123 | ZARA COAT 3  |
   
     
