Feature: Create Event
  Creates a new event
  Scenario Outline: Check required fields
    Given "<day>" and "<name>" are required
    When I press the button to create an event
    Then "<answer>" should be returned
    Examples:
      | day            | name   | answer |
      | 03.11.2019     | Peter  | wrong  |
      | 29-10-2019     | Marius | right  |
      | 29-10-2019     |        | wrong  |
      |                | Okay   | right  |