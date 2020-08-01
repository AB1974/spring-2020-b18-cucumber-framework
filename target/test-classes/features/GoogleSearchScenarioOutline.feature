
Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google search page.

  @scenarioOutline @google @smoke @regression
  Scenario Outline: Google title verification after search
    Given User is on the google search page
    When User searches "<searchValue>"
    Then User should see "<expectedTitle>" in the title

    Examples: Search values I want to search in Google
      | searchValue | expectedTitle |
      | apple       | apple         |
      | kiwi        | kiwi          |
      | orange      | orange        |
      | apple       | apple         |
      | banana      | banana        |
      | broccoli    | broccoli      |
      | cherries    | cherries      |
      | red apple   | red apple     |
      | green apple | green apple   |




    # making table pretty --> command option L ==> control alt L
