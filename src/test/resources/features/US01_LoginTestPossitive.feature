Feature: US_01 User create account and can sign in the application
  @smoke
  Scenario: TC_01 User create account with valid data
    Given User go to toUrl
    Then User click account button
    And User write email "validEmail" in the box
    And User write password "validPassword" in the box
    Then User click signIn button
    And User ensure sign in the app successfully
    Then close page
