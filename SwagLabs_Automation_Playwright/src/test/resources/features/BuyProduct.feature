Feature: Buy Product

@regression
  Scenario Outline: Buy a SwagLabs product successfully
    Given User launchedd SwagLabs application
    When User logged in the app using correct username "<UserName>" and password "<Password>"
    And User adds "<Product>" product to the cart
    And User enters Checkout details with "<FirstName>", "<LastName>", "<Zipcode>"
    And User completes Checkout process
    Then User should get the Confirmation of Order

    Examples:
      | UserName         | Password     | Product                   | FirstName    | LastName  | Zipcode   |
      | standard_user    | secret_sauce | Sauce Labs Fleece Jacket  | Asbhishek    | Dubey     | 400701    | 