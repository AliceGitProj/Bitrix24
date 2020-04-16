package com.bitrix.testPackage.Max.userStory1;

import com.bitrix.testPackage.AbstractTestBase;
import com.bitrix.testPackage.ReadDataFromExcel;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

//import javax.annotation.Priority;


public class UserStory1Test extends AbstractTestBase {
 UserStory1Page userStory1Page=new UserStory1Page();;


 /*
1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.
2. User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
3. User should be able to attach link by clicking on the link icon.
4. User should be able to insert videos by clicking on the video icon and entering the video URL.
5. User should be able to create a quote by clicking on the Comma icon.
6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
7. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
8. User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.
9. User should be able to click on "Record Video" tab to record a video and attach it with the message.
 */

    @Test(description = "1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.\n")
    public void userAbleClickOnUploadFiles() {
        test = reports.createTest("User should be able to click on upload files icon  ");
        loginPage.login();
        BrowserUtilities.wait(2);
        userStory1Page.message.click();
        wait.until(ExpectedConditions.elementToBeClickable(userStory1Page.uploadEnvelop)).click();
        BrowserUtilities.wait(1);
        Assert.assertTrue(userStory1Page.uploadFileAndImages.isEnabled());
        Assert.assertTrue(userStory1Page.downloadFromExternalDrive.isEnabled());
        userStory1Page.uploadFileAndImages.click();
        BrowserUtilities.wait(3);
        test.pass("Page from local disks is visible");
    }

    @Test(description = "3. User should be able to attach link by clicking on the link icon.")
    public void userShouldBeAbleToAttachLink(){
        test = reports.createTest("User should be able to attach link  ");
        loginPage.login();
        BrowserUtilities.wait(2);
        userStory1Page.message.click();

        wait.until(ExpectedConditions.elementToBeClickable(userStory1Page.linkButton)).click();
        BrowserUtilities.wait(1);
        userStory1Page.linkText.sendKeys("google");
        userStory1Page.linkURL.sendKeys("http://www.google.com");
        BrowserUtilities.wait(1);
        userStory1Page.saveButton.click();
        BrowserUtilities.wait(1);
        driver.switchTo().frame(userStory1Page.iframe);
        BrowserUtilities.wait(1);
        String actual = userStory1Page.wordsInsideFrame.getAttribute("href");
        String expected = "http://www.google.com/";
        Assert.assertEquals(actual,expected,"Assertion Fail !");
        test.pass("the link was attached");
    }

    @Test(description = "4. User should be able to insert videos by clicking on the video icon and entering the video URL.")
    public  void userShouldBeAbleToInsertVideos(){
        test = reports.createTest("User should be able to insert videos  ");
        loginPage.login();
        BrowserUtilities.wait(2);
        userStory1Page.message.click();

        BrowserUtilities.wait(1);
        userStory1Page.videoUploadButton.click();
        BrowserUtilities.wait(3);
        String videoURL = "https://youtu.be/ERvbs3UjHVU";
        userStory1Page.videoSours.sendKeys(videoURL);
        BrowserUtilities.wait(10);
        userStory1Page.saveVideoButton.click();
        BrowserUtilities.wait(1);

        test.pass("the videos was attached");
    }
}
