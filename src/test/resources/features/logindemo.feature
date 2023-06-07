Feature: Test Login

  Scenario Outline: Check login is successful
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to home page

    Examples:
      | username | password |
      | damo     | 12345    |
      | mani     | 12345    |