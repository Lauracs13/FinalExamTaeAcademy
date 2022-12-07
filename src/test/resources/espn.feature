@web
Feature: Espn website functionality

  Background:
    Given user is on the ESPN landing page

  Scenario: user can find the elements to login
    Given  user sees the dropdown user menu
    When user clicks on the login option
    Then login modal elements are displayed

  Scenario: user can find the elements to sign up
    Given  user sees the login modal
    When user clicks on the sign up button
    Then sign up elements are displayed

  Scenario: user can sign up successfully
    Given  user sees the sign up modal
    When user enters valid information in the form
    And user clicks on sign up button
    Then user sees their name displayed

  Scenario: user finds the expected information in the carousel
    Given  user is logged
    When user clicks on Watch option
    Then at least one carousel is present
    And each card in the carousel has a title and a small description

  Scenario: user can interact with a carousel card
    Given  user is logged
    And User is on the Watch page
    When user clicks on the second card
    And user clicks on x button
    Then the card modal disappears

  Scenario: user logs out successfully
    Given  user is logged
    When user sees their name displayed
    And user clicks on log out
    Then the username disappears

