@AddNewListInBoard
Feature: Add a new list in Board in Trello

  Scenario: Successfully create a new list in the board
    Given browser is open
    And user is logged in Trello
    When user clicks board section button
    And user should see Yours Boards
    When user clicks desired Board
    And user should see Board Title
    When user clicks to add new list
    And user enters list name
    And user clicks Add List
    Then User should see the new list
