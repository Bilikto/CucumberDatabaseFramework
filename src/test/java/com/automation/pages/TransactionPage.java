package com.automation.pages;

import com.automation.utils.ConfigFileReaderUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransactionPage extends BasePage {

    @FindBy(id="transactionTable")
    WebElement transactionsTable;

    @FindBy(xpath = "//table[@id=\"transactionTable\"]/tbody//tr[1]/td[4]")
    WebElement transactionAmount;

    public void verifyTransactionsPage() {
        Assert.assertTrue(transactionsTable.isDisplayed());
    }

    public void verifyWithdrawAmountIsDisplayedInTransactionHistory() {
        String expectedAmountFromCode = ConfigFileReaderUtils.getProperty("app.amount");
        String actualAmountFromUI = transactionAmount.getText().replace("$-", "").replace(".00", "");

        Assert.assertEquals("The UI transaction amount is not matching with user entered amount", expectedAmountFromCode, actualAmountFromUI);

        System.out.println("Expected amount from code " + expectedAmountFromCode);
        System.out.println("Actual amount from UI " + actualAmountFromUI);
    }


}
