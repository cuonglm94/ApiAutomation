#Author: Manh Cuong
@CreateUserApi
Feature: Check response when send request successfully

  @HappyCase
  Scenario Outline: Check response when send request successfully
    Given I have valid URL and method
      | URL                         | method |
      |https://dog.ceo/api/breed/corgi/images/random|GET|
      |https://dog.ceo/api/breed/corgi/images/random|POST|
      |https://dog.ceo/api/breed/:corgi/images/random|GET|

    When I send request
    Then I get <statuscode>
    
     Examples: 
      | statuscode |
      |        200 |

      
      