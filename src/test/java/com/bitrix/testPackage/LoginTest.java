package com.bitrix.testPackage;

import com.bitrix.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestBase {



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
