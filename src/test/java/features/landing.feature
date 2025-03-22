
Feature: LuggageHero Landing Page Load Verification

@RegressionTest @SmokeTest
Scenario: Verify that the landing page loads successfully
    Given the user launches the browser and opens the LuggageHero landing page
    Then the landing page should load successfully with title "LuggageHero: Luggage Storage Near Me | Locker Alternative"
