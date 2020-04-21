package com.bitrix.testPackage;

import com.bitrix.pages.LoginPage;
import com.bitrix.pages.UserStory6Page;
import com.bitrix.utilities.BrowserUtilities;
import org.testng.annotations.Test;

public class UserStory6Test extends AbstractTestBase {



    BrowserUtilities browserUtilities;

    @Test
    public void testTemp(){
        LoginPage loginPage= new LoginPage();
        UserStory6Page userStory6Page=new UserStory6Page();
        loginPage.login();
        userStory6Page.clickAppreciationTab();
        userStory6Page.uploadFilesAndImages();

    }

}
