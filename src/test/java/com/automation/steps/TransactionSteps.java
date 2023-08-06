package com.automation.steps;

import com.automation.pages.TransactionPage;
import io.cucumber.java.en.Then;

public class TransactionSteps {

    TransactionPage transactionPage = new TransactionPage();

    @Then("verify user is on Transaction page")
    public void verify_user_is_on_transaction_page() {
        transactionPage.verifyPage();
    }

    @Then("verify the withdraw amount is displayed in the transaction history")
    public void verify_the_withdraw_amount_is_displayed_in_the_transaction_history() {
        transactionPage.verifyWithdrawAmountIsDisplayedInTransactionHistory();
    }

    @Then("verify the transaction is getting updated in database")
    public void verify_the_transaction_is_getting_updated_in_database() {
        transactionPage.verifyTransactionIsUpdatedInDatabase();
    }
}
