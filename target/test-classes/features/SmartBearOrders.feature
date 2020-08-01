@smartOrder
Feature: Smartbear order placing feature
  Agile Story : When user is on the Order page, user should be able to place
  order after filling out the form


  Scenario Outline: User should be able to place order with different data sets
    Given User is logged into SmartBear Tester account and on Order page
    And User selects "<product>" from product dropdown
    And User enters "<quantity>" to quantity input box
    And User enters "<customerName>" to costumer name input box
    And User enters "<street>" to street input box
    And User enters "<city>" to city input box
    And User enters "<state>" to state input box
    And User enters "<zip>" to zip input box
    And User selects "<cardType>" as card type from radio buttons
    And User enters "<cardNumber>" to card number input box
    And User enters "<expirationDate>" to expiration date into input box
    And User clicks process button
    Then User verifies "<expectedName>" is in the table

    Examples: User fills out the form as followed from the table below:
      | product     | quantity | customerName   | street    | city    | state | zip   | cardType   | cardNumber   | expirationDate | expectedName   |
      | MyMoney     | 1        | Ken Adams      | Kinzie st | Chicago | Il    | 60004 | Visa       | 313313133315 | 12/22          | Ken Adams      |
      | FamilyAlbum | 4        | Joey Tribbiani | State st  | Chicago | Il    | 60656 | MasterCard | 313313133315 | 11/22          | Joey Tribbiani |
      | ScreenSaver | 5        | Rachel Green    | Michigan st | Chicago     | Il    | 60656 | Visa     | 313313133315 | 11/22          | Rachel Green    |
      #| MyMoney     | 5        | Chandler Bing   | Erie st     | Chicago     | Il    | 60666 | Visa     | 464675855959 | 10/22          | Chandler Bing   |
      #| FamilyAlbum | 9        | Dr DrakeRamoray | Dale st     | Arl Hgths   | Il    | 60452 | Visa     | 137452095511 | 10/22          | Dr DrakeRamoray |
      #| ScreenSaver | 10       | Monica Geller   | Euclid ave  | Arl Hgths   | Il    | 60312 | Visa     | 874576638100 | 10/22          | Monica Geller   |
      #| MyMoney     | 3        | Ross Geller     | River rd    | Des Plaines | Il    | 60666 | Visa     | 383494859454 | 10/22          | Ross Geller     |
      #| MyMoney     | 1        | Ken Adams       | Kinzie st   | Chicago     | Il    | 60312 | Visa     | 949586573625 | 12/22          | Ken Adams       |