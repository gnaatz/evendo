Feature: Create Todo
  Can I create a new todo with this input
  Scenario Outline: The input is or is not valid
    Given <title> is required
    When I press the button to create a todo
    Then <answer> should be returned3
    Examples:
      | title          | answer |
      | A title        | true   |
      |                | false  |
