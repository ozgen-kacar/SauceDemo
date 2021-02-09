Feature: Purchase
  As a user, I should be able to purchase a product from this website

  Background:
    Given user is on the login page
    And user logs in with valid credentials
    Then user verify that pageTitle is "Swag Labs"

    #user need to specialize the sorting type with one of this words
# Name (A to Z) : az, Name (Z to A): za,
# Price (low to high) : lohi, Price (high to low) :hilo
  @buySpecificItem
  Scenario: Purchase specific products on account
    Then user sort the products list by "lohi"
    Then user selected product "Sauce Labs Bike Light" add to cart
    Then user selected product "Sauce Labs Fleece Jacket" add to cart
    Then user verify number of item at the cart is "2"
    Then user remove one item from the cart
    Then user selected product "Sauce Labs Backpack" add to cart
    Then user navigate to checkout screen
    Then user give"firstName","LastName","Zipcode" information to checkout
    Then user verify correct name and price at the checkout


  @Purchase
  Scenario: Purchase first two products from list which is sorted a to z
    Then user sort the products list by "az"
    Then user stores first product name
    When user clicks the first add to cart button
    Then user stores second product name
    Then user clicks the second add to cart button
    Then user clicks the cart button
    Then user verify that selected products added successfully


