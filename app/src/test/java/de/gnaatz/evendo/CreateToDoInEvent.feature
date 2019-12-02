Feature: Create Todo
  Creates a new todo
  Scenario Outline: Check required fields
    Given "<title>" and "<Event>" is required
    When I press the button to create a todo
    Then "<answer>" should be returned here
    Examples:
      | title       | Event       |  answer |
      |             | Event title | false   |
      | A title     |             | false   |
      | A title     | Event title | true    |