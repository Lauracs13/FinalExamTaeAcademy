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
    And user click on the submit sign up button
    Then the sign up modal disappears
