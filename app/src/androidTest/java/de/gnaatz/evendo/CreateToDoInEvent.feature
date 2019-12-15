Feature: Create ToDO in Event
  Creates a ToDO in an event
  Scenario Outline: Check required fields
    Given <EventTitle> and <name> must be given
    When I press the button to create a ToDo in an event
    Then <value> must be returned1
    Examples:
      | EventTitle                 | name   | value  |
      | Homework              | Peter  | right  |
      | Create Feature Files  | Marius | right  |