package com.bitrix.testPackage;

import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.BrowserUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestBase {


    @Test(priority = 0)
    public void verifySiteLogo() {

        LoginPage loginPage = new LoginPage();

        test = reports.createTest("Verify Website logo");

        Assert.assertEquals(loginPage.getSiteLogoText(), "Authorization", "Website Logo did not match");

        test.info("Login as help desk");
        BrowserUtilities.wait(2);
        Assert.assertEquals(loginPage.getSiteLogoText(), "Authorization");
        //if assertion passed, it will set test status in report to passed


        test.pass("Website logo Authorization was verified");
    }


    @Test(dataProvider = "credentials", priority = 1)
    public void loginWithDDT(String usernameValue, String passwordValue) {
        test = reports.createTest("Verify page logo as" + usernameValue);
        LoginPage loginPage = new LoginPage();
        loginPage.login(usernameValue, passwordValue);
        test.info("Login as " + usernameValue);
        BrowserUtilities.wait(2);
        Assert.assertEquals(loginPage.getPageLogoText(), "CRM");
        test.pass("Page logo CRM was verified");
    }

    @DataProvider
    public Object[][] credentials() {
        return new Object[][]{
                {"helpdesk49@cybertekschool.com", "UserUser"},
                {"helpdesk50@cybertekschool.com", "UserUser"},
                {"hr49@cybertekschool.com", "UserUser"},
                {"hr50@cybertekschool.com", "UserUser"},
                {"marketing49@cybertekschool.com", "UserUser"},
                {"marketing50@cybertekschool.com", "UserUser"}
        };
    }

}
