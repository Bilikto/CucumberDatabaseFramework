Feature: Transaction validation

  @Regression
  Scenario: Verify user is able to withdraw funds
    Given user open website
    When user enter username
    And user enter password
    And user click on sign in button
    Then verify user is on Home page

    When user click Withdraw menu
    Then verify user is on Withdraw page

    When user select Account for Withdraw
    And user enter withdraw amount
    And user click on submit button
    Then verify user is on Transaction page
    And verify the withdraw amount is displayed in the transaction history
    And verify the transaction is getting updated in database