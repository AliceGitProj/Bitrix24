package com.bitrix.testPackage;


import com.bitrix.utilities.ReadDataFromExcel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestBase {


    //@Test(dataProvider = "credentials", dataProviderClass = ExcelUtils.class)
    @Test(dataProvider = "credentials", dataProviderClass = ReadDataFromExcel.class)
    public void loginTestWithExcel(String usernameValue, String passwordValue) {

        test = reports.createTest("Verify page logo as" + usernameValue);

        loginPage.login(usernameValue, passwordValue);

        test.info("Login as " + usernameValue);
        Assert.assertEquals(loginPage.getPageLogoText(), "CRM");

        test.pass("Page logo CRM was verified");
        test = reports.createTest("Login test for username " + usernameValue);
    }

}
