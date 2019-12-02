Feature: Change Day
  Changes the Day to show the Events
  Scenario Outline: Change the Day
    Given "<day>" is required
    When I click on an other day
    Then "<answer>" should be returned here
    Examples:
      | day            | answer |
      | 03.11.2019     | wrong  |
      | 29-10-2019     | right  |