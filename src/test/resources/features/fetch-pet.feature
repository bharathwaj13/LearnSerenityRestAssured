Feature: Fetch a Pet from the DB

  @smoke
  Scenario Outline: Fetch a Pet by passing the ID
    Given I generate a Pet named "<name>" and make it as "available"
    When I send a POST Request to Pet application with the generated body
    Then the response should have a status code 200
    When I ask for a pet using Kitty's ID:
    Then I get a Kitty named "<name>" as result
    Examples:
    |name|
    |Rocky|
    |Brock|