package com.bitrix.testPackage;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(dataProvider = "credentials", dataProviderClass = ExcelUtils.class)
    public void loginTestWithExcel(String usernameValue, String passwordValue) {

        test = reports.createTest("Verify page logo as" + usernameValue);

        loginPage.login(usernameValue, passwordValue);

        test.info("Login as " + usernameValue);
        Assert.assertEquals(loginPage.getPageLogoText(), "CRM");

        test.pass("Page logo CRM was verified");
        test = reports.createTest("Login test for username " + usernameValue);
    }

}
