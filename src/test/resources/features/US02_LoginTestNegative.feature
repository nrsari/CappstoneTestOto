@smoke
Feature: US02 User don't sign in with invalid data

  Scenario: TC_02 User don't sign in with invalid email

    Given User go to toUrl
    Then User click account button
    And User write email "invalidEmail" in the box
    And User write password "validPassword" in the box
    When User click signIn button
    Then User ensure don't sign in the application
    And close page

  Scenario: TC_03 User don't sign in with invalid password

    Given User go to toUrl
    Then User click account button
    And User write email "validEmail" in the box
    And User write password "invalidPassword" in the box
    When User click signIn button
    Then User ensure don't sign in the application
    And close page

  Scenario: TC_04 User don't sign in with invalid email and invalid password

    Given User go to toUrl
    Then User click account button
    And User write email "invalidEmail" in the box
    And User write password "invalidPassword" in the box
    When User click signIn button
    Then User ensure don't sign in the application
    And close page
