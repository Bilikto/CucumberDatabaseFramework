package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify user is on Home page")
    public void verify_user_is_on_home_page() {
        homePage.verifyUserIsOnHomePage();
    }

    @When("user click Withdraw menu")
    public void user_click_withdraw_menu() {
        homePage.clickWithdrawMenu();
    }
}
