package com.bitrix.testPackage.parvin.userStory2.ac1;

import com.bitrix.testPackage.AbstractTestBase;
import com.bitrix.utilities.ExcelUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AC1Test extends AbstractTestBase {

    /**
     * User Story:
     * As a user, I should be able to assign
     * tasks by clicking on Task tab under Active Stream.
     * To enable screen reader support, press ⌘+Option+Z To learn about keyboard shortcuts, press ⌘slash
     */

    AC1Page ac1Page;

    /**
     * AC1:
     * User should be able to click on "High Priority" checkbox
     * to set the current task to a top priority task.
     */
    @Test(dataProvider = "credentialsFromExcel")
    public void verifyHighPriorityCheckboxClicked(String usernameValue, String passwordValue) {

        test = reports.createTest("Verify AC1 as userName " + usernameValue);
        loginPage.login(usernameValue, passwordValue);

        test.info("Login as " + usernameValue);
        Assert.assertEquals(loginPage.getPageLogoText(), "CRM");
        test.pass("Page logo CRM was verified");

        ac1Page = new AC1Page();

        test = reports.createTest("Verify taskTab is visible");
        wait.until(ExpectedConditions.visibilityOf(ac1Page.taskTab));
        Assert.assertEquals(ac1Page.getTaskTabText(), "TASK");
        test.pass("taskTab is verified");

        ac1Page.taskTab.click();
        test = reports.createTest("Verify HighPriorityCheckBox is visible");
        wait.until(ExpectedConditions.visibilityOf(ac1Page.highPriorityCheckBox));
        Assert.assertEquals(ac1Page.getHighPriorityCheckBox(), "High Priority");
        test.pass("HighPriorityCheckBox is verified");

        test = reports.createTest("Verify HighPriorityCheckBox is enabled");
        ac1Page.highPriorityCheckBox.click();
        Assert.assertTrue(ac1Page.highPriorityCheckBox.isEnabled());
        test.pass("HighPriorityCheckBox is enabled");
    }

    @DataProvider
    public Object[][] credentialsFromExcel() {

        String path = "BitrixCredentials.xlsx";
        String spreadSheet = "Credentials";

        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        return excelUtil.getDataArray();
    }


}
