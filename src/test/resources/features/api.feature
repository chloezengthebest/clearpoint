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
  Scenario: Delete post example : Delete a to-do
    When Send DELETE http request with Id 25
    Then I should receive SUCCESS response code 200
