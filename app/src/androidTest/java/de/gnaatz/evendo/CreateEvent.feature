Feature: Create Event
  Can I create a new Event with this input
  Scenario Outline: The input is or is not valid
    Given <title> is input value
    When I create an event with this input
    Then <value> shall be returned
    Examples:
      | title  | value |
      | Title  | right |
      | 01     | right |
      |        | false |