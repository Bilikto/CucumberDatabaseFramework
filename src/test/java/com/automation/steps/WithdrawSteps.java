package com.automation.steps;

import com.automation.pages.WithdrawPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithdrawSteps {

    WithdrawPage withdrawPage = new WithdrawPage();

    @Then("verify user is on Withdraw page")
    public void verify_user_is_on_withdraw_page() {
        withdrawPage.verifyWithdrawPage();
    }

    @When("user select Account for Withdraw")
    public void user_select_account_for_withdraw() {
        withdrawPage.selectAccountForWithdraw();
    }

    @When("user enter withdraw amount")
    public void user_enter_withdraw_amount() {
        withdrawPage.enterWithdrawAmount();
    }

    @When("user click on submit button")
    public void user_click_on_submit_button() {
        withdrawPage.clickSubmitButton();
    }
}
