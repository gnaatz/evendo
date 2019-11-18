Feature: Create Todo
  Creates a new todo
  Scenario Outline: Check required fields
    Given "<title>" is required
    When I press the button to create a todo
    Then "<answer>" should be returned here
    Examples:
      | title          | answer |
      |                | false  |
      | A title        | true   |
