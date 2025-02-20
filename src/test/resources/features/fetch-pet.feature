Feature: Fetch a Pet from the DB

  Scenario: Fetch a Pet by passing the ID
    Given Kitty is available in the pet store
    When I ask for a pet using Kitty's ID:
    Then I get Kitty as result