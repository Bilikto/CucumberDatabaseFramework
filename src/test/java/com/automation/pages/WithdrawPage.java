package com.automation.pages;

import com.automation.utils.ConfigFileReaderUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WithdrawPage extends BasePage {

    @FindBy(id="page-title")
    WebElement withdrawTitle;

    @FindBy(id="selectedAccount")
    WebElement selectAccountDropdown;

    @FindBy(id="amount")
    WebElement withdrawAmountInput;

    @FindBy(xpath="//div[@class='card-footer']/button[@type='submit']")
    WebElement submitBtn;

    public void verifyWithdrawPage() {
        Assert.assertTrue(withdrawTitle.isDisplayed());
    }

    public void selectAccountForWithdraw() {
        Select select  = new Select(selectAccountDropdown);
        select.selectByVisibleText("TestChecking (Standard Checking)");
    }

    public void enterWithdrawAmount() {
        withdrawAmountInput.sendKeys(ConfigFileReaderUtils.getProperty("app.amount"));
    }

    public void clickSubmitButton() {
        submitBtn.click();
    }

}
