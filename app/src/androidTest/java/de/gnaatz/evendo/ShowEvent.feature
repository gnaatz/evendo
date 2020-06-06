Feature: Show Event
  Can I show an Event
  Scenario Outline: I can show or not show the Event
    Given <event> shall be given
    When I click on an event
    Then <value> should be shown
    Examples:
      | event            | value  |
      | Homework         | right  |
      | 08               | right  |
      |                  | false  |