# ClearPoint Test Demo

This automation framework using Selenium with Java, Junit, Cucumber and Maven under Page Object Model.

### Test Scenario
Here test two scenarios. 
1. API endpoint: https://jsonplaceholder.typicode.com/todos
2. UI Test includes Countdown and Twitter login and https://www.countdown.co.nz/ 

### Way to execute the tests
1. `mvn clean test` (please see note if it doesn't work)
2. run from `feature` files directly
3. run `RunCucumberTest` with Junit

### What contains in this project?
* It can run with different browsers, also provide an option is Headless webdriver.
 (default by **_chrome_** you can find setting in **_config.properties_**)
* Hooks (@Before and @After)
* In `RunCucumberTest` file, you can run scenarios with a particular tag. like @chrome, @headless, @api, @countdown
* `Wait till` for finding elements
* Cucumber Reporting. 
    * Report would be auto generated when run via maven. Please see attachment report1.
    * Or you can find here under Target file _**testReport.html**_, Please see attachment report2.


### Note!!!
1.If  unable to find htmlunitdriver when build, please download 3rd party jar file from `https://github.com/SeleniumHQ/htmlunit-driver/releases`
and add to dependencies.

```Gherkin 
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
      | EmailAddress             | password  |
      | chloezeng310@gmail.com   | password  |
      | tester@gmail.com         | invalid   |

@twitter @testEnv
Feature: This is feature about Website called Twitter

  @chrome @headless @signIn
  Scenario Outline: This is Twitter Negative Login Scenarios
    Given "TwitterLogin" website
    When Login with incorrect "<EmailAddress>" and "<password>" in "TwitterLogin" Page
    Then Error would show up in "TwitterLogin" Page

    Examples:
      | EmailAddress             | password  |
      | chloezeng310@gmail.com   | password  |
      | tester@gmail.com         | invalid   |
```
```Gherkin 
@api @testEnv
Feature: This is feature about API-Todo

  @api
  Scenario: Get post example : Get the list of all todos
    When Send GET http request
    Then I should receive SUCCESS response code 200

  @api
  Scenario: Get post example : GET a to-do
    When Send GET http request with Id 25
    Then I should receive SUCCESS response code 200

  @api
  Scenario: Post post example : Post a to-do
    When Send POST http request with Id 25
    Then I should receive SUCCESS response code 201

  @api
  Scenario: Put post example : Update a to-do
    When Send PUT http request with Id 25
    Then I should receive SUCCESS response code 200

  @api
  Scenario: Delete post example : delete a to-do
    When Send DELETE http request with Id 25
    Then I should receive SUCCESS response code 200

```

### To-do list
- [ ] Run in Jenkins
    > can run in docker container
- [ ] Dynamic extent report with features name and scenarios
- [ ] Screenshot when test failed


#### Author

Chloe Zeng

email: chloezeng310@gmail.com





