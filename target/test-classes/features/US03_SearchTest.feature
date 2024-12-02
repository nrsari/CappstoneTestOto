@smoke
Feature: US_03 User search items in the applications

  Background:
    Given User go to toUrl

  Scenario: TC_05 User search phone and find results
    Then user put phone in search box
    And user ensure the item in result
    And close page

  Scenario: TC_06 User search dress and find results
    Then user put dress in search box
    And user ensure the item in result
    And close page

  Scenario: TC_07 User search nutella and find results
    Then user put nutella in search box
    And user ensure the item don't find in result
    And close page