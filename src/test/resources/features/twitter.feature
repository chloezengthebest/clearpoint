@twitter @testEnv
Feature: This is feature about Website called Twitter

  @chrome @headless @signIn
  Scenario Outline: This is Twitter Negative Login Scenarios
    Given "TwitterLogin" website
    When Login with incorrect "<username>" and "<password>" in "TwitterLogin" Page
    Then Error would show up in "TwitterLogin" Page

    Examples:
      | username               | password |
      | tester@gmail.com       | password |
      | chloezeng310@gmail.com | invalid  |

