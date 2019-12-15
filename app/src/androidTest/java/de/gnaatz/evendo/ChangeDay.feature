Feature: Change Day
  Changes the day
  Scenario Outline: Check required fields
    Given <newDay> is needed
    When I click on another Day
    Then <value> might be returned3
    Examples:
      | newDay         | value |
      | 03.11.2019     | right  |
      | 29-10-2019     | right  |