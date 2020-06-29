Feature: Create ToDO in Event
  Can I create a ToDO in an event with this input
  Scenario Outline: Input is or is not valid
    Given <EventTitle> and <title> are input values
    When I create a ToDo in an event with this input
    Then <value> must be returned1
    Examples:
      | EventTitle                 | title           | value  |
      | Homework                   | math p.55 ex.2  | right  |
      | Create Feature Files       | ChangeDay Event | right  |
      | Buy flowers                |                 | false  |