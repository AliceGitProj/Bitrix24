package com.bitrix.tests;

import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTestBase {

    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("bitrix");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 25);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();

    }

}
