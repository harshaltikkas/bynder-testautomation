@Feature
Feature: User Login

  @SmokeTests
  Scenario: Successful Login with valid credentials
    Given User is on Byndr portal's login screen
    When User enters valid username "byndr_student4" and password "password"
    Then User is taken to Home page

  