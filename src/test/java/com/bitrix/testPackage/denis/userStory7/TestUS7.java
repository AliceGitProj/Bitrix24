package com.bitrix.testPackage.denis.userStory7;
//package com.bitrix.tests;

import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/* USER STORY #7 As a user, I should be able to send annoucement from Annoucement subheadding from "More" under Activity Stream.
Acceptance criteria:
* 1. User should be able to click on upload files icon to upload files and pictures from local disks, download from external drive, select documents from bixtrix24, and create files to upload.
2. User should be able to add users and recipients from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
3. User should be able to attach link by clicking on the link icon.
4. User should be able to insert videos by clicking on the video icon and entering the video URL.
5. User should be able to create a quote by clicking on the Comma icon.
6. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
7. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
8. User should be able to click on the Topic icon to see the annoucement Topic text box displays on top of the message box.
9. User should be able to click on "Record Video" tab to record a video and attach it with the message.
10. User should be able to add tags by selecting existing tags or creating new tags by clicking on the # icon.
To enable screen reader support, press ⌘+Option+Z To learn about keyboard shortcuts, press ⌘slash
* */


public class TestUS7 {


    final String userNameHelpDesk = "helpdesk50@cybertekschool.com";
    final String userNameHR = "hr50@cybertekschool.com";
    final String userNameMarketing = "marketing50@cybertekschool.com";
    final String password = "UserUser";



    @Test (description = "/* USER STORY #7 As a user, I should be able to send " +
            "annoucement from Annoucement subheadding from More under Activity Stream.")
    public void US7 () {

        BrowserUtilities.wait(3);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(userNameHelpDesk);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        BrowserUtilities.wait(3);
        driver.findElement(By.id("feed-add-post-form-link-text")).click();
        BrowserUtilities.wait(1);
        WebElement announcementButton = driver.findElement(By.xpath("//span[@class='menu-popup-item-text' and contains(text(),'Announcement')]"));
        announcementButton.click();
        WebElement messageBox = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(messageBox);

        WebElement textArea = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        textArea.sendKeys("Hello Java-13!");
        driver.switchTo().defaultContent();
        BrowserUtilities.wait(2);
        driver.findElement(By.id("blog-submit-button-save")).click();
        BrowserUtilities.wait(5);


        String expected = "Hello Java-13!";
        String full = driver.findElement(By.xpath("//div[contains(text(),'Hello Java-13!')]")).getText();
        String actual = full.substring(0,14);
        Assert.assertEquals(actual,expected);
        driver.close();

    }
    @Test (description = "* 1. User should be able to click on upload files icon to upload files " +
            "and pictures from local disks, download from external drive, select documents from " +
            "bixtrix24, and create files to upload.")
    public void AC1 () {
        BrowserUtilities.wait(3);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(userNameHelpDesk);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        BrowserUtilities.wait(3);
        driver.findElement(By.id("feed-add-post-form-link-text")).click();
        BrowserUtilities.wait(1);
        WebElement fileButton = driver.findElement(By.xpath("//span[@class='menu-popup-item-text' and contains(text(),'File')]"));
        fileButton.click();
        BrowserUtilities.wait(3);
        WebElement uploadFilesAndImages=driver.findElement(By.xpath("//input[@name='bxu_files[]']"));
        WebElement selectDocumentsFromBitrix = driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-light-title-text diskuf-selector-link'])[1]"));
        WebElement downloadFromExternalDrive = driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-light-title-text'])[2]"));
        WebElement office365=driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-link'])[1]"));
        WebElement googleDrive=driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-link'])[2]"));
        WebElement dropBox = driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-link'])[3]"));
        WebElement createFileFromDocument = driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-link'])[4]"));
        WebElement createFileFromSpreadsheet = driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-link'])[5]"));
        WebElement createFileFromPresentation = driver.findElement(By.xpath("(//span[@class='wd-fa-add-file-editor-link'])[6]"));

        Assert.assertTrue(uploadFilesAndImages.isEnabled());
        Assert.assertTrue(selectDocumentsFromBitrix.isEnabled());
        Assert.assertTrue(downloadFromExternalDrive.isEnabled());
        Assert.assertTrue(office365.isEnabled());
        Assert.assertTrue(googleDrive.isEnabled());
        Assert.assertTrue(dropBox.isEnabled());
        Assert.assertTrue(createFileFromSpreadsheet.isEnabled());
        Assert.assertTrue(createFileFromDocument.isEnabled());
        Assert.assertTrue(createFileFromPresentation.isEnabled());

        driver.close();

    }

}

