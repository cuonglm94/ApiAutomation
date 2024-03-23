#Author: Manh Cuong
@ListUsersApi
Feature: Check response when send request successfully

  @HappyCase
  Scenario: Check response when send request successfully
  	Given I have valid URL and method.
		When I send request
		Then I get status code and response

