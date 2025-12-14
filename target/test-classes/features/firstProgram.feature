Feature: Application Login

Scenario Outline: Verify the Login

@Search
Scenario Outline: Verify the login with parameters
    Given User is on NetBanking Landing page
    When User logs into application with "<Username>" and "<password>"
    Then Homepage is displayed

Examples:
    | Username | password |
    | 123      | raju     |
    | Admin    | 345      |


@Smoke @Search
Scenario:Verify the login with parameters

Given  User is on NetBanking Landing page
When  User logs into application with "vaasu" and "raju"
Then  Homepage is displayed