@tag
Feature: Purchase the order from E-commerce Website
  I want to use this template for my feature file
  
  Background:
  Given i landed on the E-commerce page

  @Regression
  Scenario Outline: Positive test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I want product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name             |     password     | productName      |
      | test671@test.com |     Zxcvbnm@671  | ADIDAS ORIGINAL  |
      | test672@test.com |     Zxcvbnm@672  | IPHONE 13 PRO    |
