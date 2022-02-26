Feature: Search for Flight

  Narrative:
  In order to search for a Flight
  The user enter the information for a valid flight

  Scenario: Search for Flight
    Given I'm in the main page
    And I Accept Cookies
    When I search for flight with the following data:
      | origen   | destino | fechaIda       |
      | MAD      | BCN     | 2022-07-01     |
    Then I get the existing flight page
