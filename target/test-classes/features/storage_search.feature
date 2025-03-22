 #This feature validates the homepage and search functionality for luggage storage locations.
Feature: Luggage Storage Search Functionality

  @RegressionTest @SmokeTest
  Scenario Outline: Verify homepage and search functionality for luggage storage locations
    Given the user is on the LuggageHero homepage
    When the homepage is fully loaded
    Then the page title should contain "LuggageHero"
    And the search bar should be visible and functional
    When the user searches for "<cityname>" luggage storage locations
    And the user selects the date "<date>" and "<bags>" bags
    Then search results should display relevant luggage storage locations for "<cityname>"
    
    # Data-driven examples to run the scenario with multiple input sets
    Examples:
      | cityname | date       | bags |
      | London   | 2025-04-01 | 3    |
      |Copenhagen|2025-04-01  | 5    |
      |Haldwani  |2025-04-01  | 1    |