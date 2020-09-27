@countdown @testEnv
Feature: This is feature about Website called Countdown

  @chrome
  Scenario: This is close easyEmailSignup page
    Given "Countdown" website
    When I close "easyEmailSignup"
    Then I should in "Countdown" Page

  @chrome @headless
  Scenario Outline: This is Login Scenario
    Given "CountdownLogin" website
    When Login with incorrect "<EmailAddress>" and "<password>" in "Countdown" Page
    Then Error would show up in "CountdownLogin" Page

    Examples:
      | EmailAddress           | password |
      | chloezeng310@gmail.com | password |