package com.bitrix.tests;

import com.bitrix.pages.LoginPage;
import com.bitrix.pages.TaskPage;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NewTaskTest extends AbstractTestBase {
    LoginPage loginPage=new LoginPage();
    TaskPage taskPage=new TaskPage();
@Test
    public void createNewTask(){

        loginPage.login();

    BrowserUtilities.wait(3);
     taskPage.clickOnTask();
     BrowserUtilities.wait(3);
taskPage.createNewTask();
    BrowserUtilities.wait(3);



    }

}
