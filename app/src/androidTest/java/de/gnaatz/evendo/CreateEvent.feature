Feature: Create Event
  Creates a new event
  Scenario Outline: Check required fields
    Given <day> and <name> are required
    When I press the button to create an event
    Then <value> shall be returned
    Examples:
      | day            | name   | value |
      | 03.11.2019     | Peter  | right  |
      | 29-10-2019     | Marius | right  |