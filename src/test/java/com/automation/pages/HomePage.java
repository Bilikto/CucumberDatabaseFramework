package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id="page-title")
    WebElement dashboardTitle;

    @FindBy(id="withdraw-menu-item")
    WebElement withdrawMenu;

    public void verifyPage() {
        Assert.assertTrue(dashboardTitle.isDisplayed());
    }

    public void clickWithdrawMenu() {
        withdrawMenu.click();
    }
}
