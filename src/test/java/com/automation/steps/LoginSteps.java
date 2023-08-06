package com.automation.steps;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user open website")
    public void user_open_website() {
        loginPage.openWebsite();
    }

    @When("user enter username")
    public void user_enter_username() {
        loginPage.enterUserName();
    }

    @When("user enter password")
    public void user_enter_password() {
        loginPage.enterPassword();
    }

    @When("user click on sign in button")
    public void user_click_on_sign_in_button() {
        loginPage.clickOnSignInButton();
    }

}
