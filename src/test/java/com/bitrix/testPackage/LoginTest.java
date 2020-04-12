package com.bitrix.testPackage;

import com.bitrix.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestBase {

    @Test()
    public void verifySiteLogo() {

        test = reports.createTest("Verify Website logo");
        Assert.assertEquals(loginPage.getSiteLogoText(), "Authorization", "Website Logo did not match");

        test.info("Login as help desk");
        Assert.assertEquals(loginPage.getSiteLogoText(), "Authorization");

        test.pass("Website logo Authorization was verified");
    }

    @Test(dataProvider = "credentialsFromExcel", priority = 1)
    public void loginTestWithExcel(String usernameValue, String passwordValue) {

        test = reports.createTest("Verify page logo as" + usernameValue);

        loginPage.login(usernameValue, passwordValue);

        test.info("Login as " + usernameValue);
        Assert.assertEquals(loginPage.getPageLogoText(), "CRM");

        test.pass("Page logo CRM was verified");
        test = reports.createTest("Login test for username " + usernameValue);
    }

    @DataProvider
    public Object[][] credentialsFromExcel() {

        String path = "BitrixCredentials.xlsx";
        String spreadSheet = "Credentials";

        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        return excelUtil.getDataArray();
    }
}
