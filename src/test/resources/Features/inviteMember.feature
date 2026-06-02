@InviteMember
Feature: feature to test invite member functionality

  Scenario Outline: Check member invite is successful with valid email
    Given browser is open
    And user is logged in using <username> and <password>
    And user is on home page
    When user click add member
    And user click Invite Workspace members
    And user enters new member email or name <memberEmailOrName>
    And hits enter on invite member to workspace text box
    Then new member is invited

    Examples: 
      | username              | password       | memberEmailOrName     |
      | f223635@cfd.nu.edu.pk | password==true | f223708@cfd.nu.edu.pk |
