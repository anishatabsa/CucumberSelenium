Feature: Takealot User Registration

  @Sanity
  Scenario: User registration with valid details
    Given User is on the registration page
    Then The Registration page should be displayed
    When User fills the registration form with valid details
    | Clive | Ronald | clive@test.com | 34 | Male | American | USA |
    When User clicks on the Register button
    Then User registration should be completed successfully