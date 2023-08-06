package com.automation.pages;

import com.automation.utils.ConfigFileReaderUtils;
import com.automation.utils.DriverUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="username")
    WebElement userNameInput;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(id="submit")
    WebElement submitBtn;

    public void openWebsite() {
        DriverUtils.getDriver().get(ConfigFileReaderUtils.getProperty("app.url"));
    }

    public void enterUserName() {
        userNameInput.sendKeys(ConfigFileReaderUtils.getProperty("app.username"));
    }

    public void enterPassword() {
        passwordInput.sendKeys(ConfigFileReaderUtils.getProperty("app.password"));
    }

    public void verifyPage() {
        Assert.assertTrue(userNameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
    }

    public void clickOnSignInButton() {
        submitBtn.click();
    }

}
