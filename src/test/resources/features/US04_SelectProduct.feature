@smoke
Feature: US04 User can select product and add to cart  page

  Scenario: TC_11 User added product to cart and  take screenshot

    Given User go to toUrl
    When user write "Shirt" in search box
    Then user ensure the item in result
    And User take a screenshot and save it as"PageSS"
    Then User click first product
    And User ensure the valid product open
    And User add to selected product to cart


  Scenario: TC_12 User delete product to cart

    Given User click cart button
    And User delete the product from chart
    And User accept delete popup
    Then User take success message
    Then close page