Feature: Takealot Login

  Background:
    Given User is on Takealot home page
    When User clicks on the login link
    Then User should be navigated to the login page

  @Sanity1
  Scenario: User is able to login with valid credentials
    Given User is on login page
    When User enters login credentials as username "test" and password "test@123"
    When User clicks on the Login button
    Then Takealot Home Page is displayed

  @Negative @Sanity
  Scenario: User is unable to login with invalid credentials
    Given User is on login page
    When User enters login credentials as username "invalid_test" and password "invalid@123"
    When User clicks on the Login button
    Then Error is displayed as "Invalid credentials"

  @Regression
  Scenario Outline: Test login using multiple different credentials
    Given User is on login page
    When User enters login details as username "<Username>" and password "<Password>"
    When User clicks on the Login button
    Then Takealot Home Page is displayed
    Examples:
      | Username | Password |
      | jenkins | ci123 |
      | admin | admin123 |
      | user | user123 |
      | manager | manager123 |