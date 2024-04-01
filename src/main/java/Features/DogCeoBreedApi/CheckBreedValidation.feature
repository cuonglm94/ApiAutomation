#Author: Manh Cuong
@CreateUserApi
Feature: Check response when send request successfully

  @HappyCase
  Scenario Outline: Breed Api Validation
    Given I have valid URL and method of BreedApi
      | URL                                               | method |
      | https://dog.ceo/api/breed/breedName/images/random | GET    |
    When I send request with "<FieldName>" and "<Value>"
    Then I get <ExpectedStatusCode> and "<ExpectedMessage>"

    Examples: 
      | FieldName | Value  | ExpectedStatusCode | ExpectedMessage                               |
      | breedName | asdddd |                404 | Breed not found (master breed does not exist) |
      | breedName | corgii  |                404 | Breed not found (master breed does not exist) |
