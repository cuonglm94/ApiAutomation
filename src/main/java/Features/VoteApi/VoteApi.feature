#Author: Manh Cuong
@VoteApi
Feature: Check response when send request successfully

  @HappyCase
  Scenario: Check response when send request successfully
    Given I have valid URL and method
      | URL                         | method |
      | https://api.thecatapi.com/v1/votes | POST   |
    Given I have valid request body
      | RequestBodyName                           |
      | \\CreateUserApi\\CreateUserRequestBody.json |
    When I send request with request body
    Then I get <statuscode>
     Examples: 
      | statuscode |
      |        201 |
