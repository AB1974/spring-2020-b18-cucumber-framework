@regression
Feature: Example of how to implement data table


  @dataTable
  Scenario: Something happens
    #Given User does something
    Then User should see below words displayed
      | Apple    |
      | Kiwi     |
      | Orange   |
      | Cucumber |
      | Broccoli |

    #command option L
    #control alt L

  Scenario: Something happens
    #Given User does something
    Then User should see below words displayed on the page