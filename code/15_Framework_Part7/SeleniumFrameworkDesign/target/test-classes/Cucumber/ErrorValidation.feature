@tag
Feature: Error validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Positive test of login error validation
  	Give n i landed on the E-commerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." error message is displayed on login page

    Examples: 
      | name             |     password     |
      | test671@test.com |     Zxcvbnm@123  |
      #| test672@test.com |     Zxcvbnm@654  |