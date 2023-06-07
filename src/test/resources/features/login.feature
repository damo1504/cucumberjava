Feature: Login Feature

  Scenario: Check login successful

    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to home page