package com.bitrix.testPackage;

import com.bitrix.pages.LoginPage;
import com.bitrix.pages.UserStory6Page;
import com.bitrix.utilities.BrowserUtilities;
import org.testng.annotations.Test;

public class UserStory6Test extends AbstractTestBase {

    BrowserUtilities browserUtilities;
    UserStory6Page userStory6Page;

    @Test
    public void testTemp(){
        browserUtilities=new BrowserUtilities();
        userStory6Page=new UserStory6Page();

        userStory6Page.login();
        userStory6Page.clickAppreciationTab();
        userStory6Page.typeText("Hello");
        userStory6Page.uploadFilesAndImages();
        userStory6Page.downLoadExternalDrive();
        userStory6Page.submitAndSave();

    }


}
