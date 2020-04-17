package com.bitrix.testPackage;

import com.bitrix.pages.LoginPage;
import com.bitrix.pages.PollPage;
import com.bitrix.utilities.BrowserUtilities;
import org.testng.annotations.Test;

public class TestCase4 extends AbstractTestBase {

    LoginPage loginPage;
    PollPage pollPage;
    BrowserUtilities bu;

    @Test
    public void testCase4() {
        loginPage = new LoginPage();
        pollPage = new PollPage();
        bu = new BrowserUtilities();

        loginPage.login();
        pollPage.clickPollTab();
        pollPage.clickUploadFilesIcon();
        pollPage.uploadFilesAndImages();
        pollPage.uploadSelectDocumentFromBitrix24();
        pollPage.downloadFromExternalDrive();
        pollPage.createUsingGoogleDocs();
        pollPage.addMoreUsersFromRecent();
        pollPage.attachedLink();
        pollPage.createdQuote();
        pollPage.addedMention();
        pollPage.visualEditorClickability();
        pollPage.topicIcon();
        pollPage.recordIcon();
        pollPage.question();

    }


}