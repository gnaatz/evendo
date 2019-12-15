Feature: Show Event
  Show an Event
  Scenario Outline: Check required fields
    Given <day> shall be given
    When I click on an event
    Then <value> should be shown
    Examples:
      | day            | value  |
      | 03.11.2019     | right  |
      | 29-10-2019     | right  |