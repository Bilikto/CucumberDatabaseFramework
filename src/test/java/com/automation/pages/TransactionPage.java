package com.automation.pages;

import com.automation.utils.ConfigFileReaderUtils;
import com.automation.utils.DataBaseUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.ResultSet;

public class TransactionPage extends BasePage {

    @FindBy(id="transactionTable")
    WebElement transactionsTable;

    @FindBy(xpath = "//table[@id=\"transactionTable\"]/tbody//tr[1]/td[4]")
    WebElement transactionAmount;

    @FindBy(xpath = "//table[@id=\"transactionTable\"]/tbody//tr[1]/td[3]")
    WebElement transactionDescription;

    private String expectedAmountFromCode;
    private String transactionNumber;
    private String actualAmountFromUI;
    private String actualAmountFromDB;
    private String query;

    private ResultSet res;

    public void verifyTransactionsPage() {
        Assert.assertTrue(transactionsTable.isDisplayed());
    }

    public void verifyWithdrawAmountIsDisplayedInTransactionHistory() {
        expectedAmountFromCode = ConfigFileReaderUtils.getProperty("app.amount");
        actualAmountFromUI = transactionAmount.getText().replace("$-", "").replace(".00", "");

        Assert.assertEquals("The UI transaction amount is not matching with user entered amount", expectedAmountFromCode, actualAmountFromUI);

        System.out.println("Expected amount from Code " + expectedAmountFromCode);
        System.out.println("Actual amount from UI " + actualAmountFromUI);
    }

    public void verifyTransactionIsUpdatedInDatabase() {
        try {
            transactionNumber = transactionDescription.getText().replace(" (WTH) - Online Withdrawl", "");
            query = ConfigFileReaderUtils.getProperty("db.query") + "\'"+ transactionNumber +"\'";
            res = DataBaseUtils.executeQuery(query);
            res.next();
            actualAmountFromDB = res.getString("amount").replace("-", "").replace(".00", "");

            Assert.assertEquals("The amount mismatches in Code and Database", expectedAmountFromCode, actualAmountFromDB);

            String expectedAmountFromUI = actualAmountFromUI;
            Assert.assertEquals("The amount mismatches in UI and Database", expectedAmountFromUI, actualAmountFromDB);

            System.out.println("======== DB Testing ========");
            System.out.println("Expected amount from Code " + expectedAmountFromCode);
            System.out.println("Actual amount from UI " + actualAmountFromUI);
            System.out.println("Actual amount from Database " + actualAmountFromDB);
            System.out.println("Transaction decription number " + transactionNumber);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
