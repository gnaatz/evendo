Feature: Change Day
  Can I change the day
  Scenario Outline: I click a valid or invalid field
    Given <newDay> is given
    When I click on this Day
    Then <value> might be returned3
    Examples:
      | newDay         | value |
      | 03.11.2019     | right |
      | 29-10-2019     | right |
      |                | false |