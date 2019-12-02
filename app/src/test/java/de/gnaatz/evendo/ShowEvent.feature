Feature: Show Event
  Expands the Even to show all information
  Scenario Outline: Check which Event is clicked
    Given "<day>" and "<name>" are required
    When I press on the Event
    Then "<answer>" should be returned here
    Examples:
      | day            | name   | answer |
      | 03.11.2019     | Peter  | wrong  |
      | 29-10-2019     | Marius | right  |
      | 29-10-2019     |        | wrong  |
      |                | Okay   | right  |