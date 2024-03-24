#Author: Manh Cuong
@CreateUserApi
Feature: Check response when send request successfully

  @HappyCase
  Scenario: Check response when send request successfully
    Given I have valid URL and method
      | URL                         | method |
      | https://reqres.in/api/users | POST   |
      Given I have valid request body
    When I send request with request body
    Then I get status code and response
