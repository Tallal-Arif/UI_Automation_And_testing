@Login
Feature: feature to test login functionality

  #Scenario: Check login is successful with valid credentials
    #Given browser is open
    #And user is on login page
    #When user enters username
    #And hits enter
    #And user enters password
    #And hits enter
    #Then user is navigated to the home page

  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters username <username>
    And hits enter
    And user enters password <password>
    And hits enter
    Then user is navigated to the home page

    Examples: 
      | username              | password       |
      | f223635@cfd.nu.edu.pk | password==true |
