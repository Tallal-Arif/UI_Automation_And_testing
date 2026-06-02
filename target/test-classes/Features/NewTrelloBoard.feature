@NewTrelloBoard
Feature: Add a new board in Trello

  Scenario: Successfully create a new board
    Given browser is open
    And user is log in using <username> and <password>
    When user clicks create button
    And user enters Board Title <boardTitle>
    And user clicks create
    Then User should see the new board

        Examples: 
      | username              | password       | boardTitle |
      | f223635@cfd.nu.edu.pk | password==true | sample board |