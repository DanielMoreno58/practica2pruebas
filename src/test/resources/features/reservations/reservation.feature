Feature: Search for Flight

  Narrative:
  In order to search for a Flight
  The user enter the information for a valid flight

  Scenario: Search for Flight
    Given I'm in the main page
    When I search for flight:
      | name   | phone | email            | date       | number | time  | color   |
      | Aslak  | 11    | e@aslakhelle.oy  | 2017-02-17 | 1      | 12:00 | #4e2727 |
    Then I get the existing flight page
