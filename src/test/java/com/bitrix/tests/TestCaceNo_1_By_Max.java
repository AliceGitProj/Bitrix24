package com.bitrix.tests;

import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaceNo_1_By_Max {



    @Test
    public void UserStory_No_1() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
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

    @Test
    public void Te() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://login1.nextbasecrm.com/");
        WebElement userName = driver.findElement(By.cssSelector("[name='USER_LOGIN']"));
        WebElement password = driver.findElement(By.cssSelector("[name='USER_PASSWORD']"));
        BrowserUtilities.wait(2);
        userName.sendKeys("hr50@cybertekschool.com");
        password.sendKeys("UserUser", Keys.ENTER);
        BrowserUtilities.wait(2);
        WebElement message = driver.findElement(By.cssSelector("[id='feed-add-post-form-tab-message']"));
        message.click();
        BrowserUtilities.wait(1);

        WebElement uploadEnvelop = driver.findElement(By.cssSelector("[id='bx-b-uploadfile-blogPostForm']"));
        uploadEnvelop.click();
        BrowserUtilities.wait(1);
        WebElement uploadFileAndImages = driver.findElement(By.xpath("(//table//tbody//tr//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main'])[1]"));
        String fotoPath = "/Users/user/Desktop/Screen Shot 2020-04-09 at 10.25.41 AM.png";
        uploadFileAndImages.click();

        // actions.dragAndDrop(fotoPath,uploadFileAndImages);

        BrowserUtilities.wait(1);


        driver.quit();

    }

    //3. User should be able to attach link by clicking on the link icon.
    @Test
    public void Test_3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://login1.nextbasecrm.com/");
        WebElement userName = driver.findElement(By.cssSelector("[name='USER_LOGIN']"));
        WebElement password = driver.findElement(By.cssSelector("[name='USER_PASSWORD']"));
        userName.sendKeys("hr50@cybertekschool.com");
        password.sendKeys("UserUser", Keys.ENTER);
        BrowserUtilities.wait(2);
        WebElement message = driver.findElement(By.cssSelector("[id='feed-add-post-form-tab-message']"));
        message.click();
        BrowserUtilities.wait(1);

        WebElement linkButton = driver.findElement(By.cssSelector("[title='Link']"));
        linkButton.click();
        BrowserUtilities.wait(1);
//        WebElement smollEditLincButtom = driver.findElement(By.cssSelector("[data-bx-dropdown-value='edit_link']"));
//        wait.until(ExpectedConditions.elementToBeClickable(smollEditLincButtom)).click();
//        BrowserUtilities.wait(1);
        WebElement linkText = driver.findElement(By.cssSelector("[placeholder='Link text']"));
        linkText.sendKeys("google");
        WebElement linkURL = driver.findElement(By.cssSelector("[placeholder='Link URL']"));
        linkURL.sendKeys("http://www.google.com");
        BrowserUtilities.wait(1);
        WebElement saveButton = driver.findElement(By.cssSelector("[class='adm-btn-save']"));
        saveButton.click();
        BrowserUtilities.wait(1);

        driver.quit();
    }
    // 4. User should be able to insert videos by clicking on the video icon and entering the video URL.
    @Test
    public void Test_4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://login1.nextbasecrm.com/");
        WebElement userName = driver.findElement(By.cssSelector("[name='USER_LOGIN']"));
        WebElement password = driver.findElement(By.cssSelector("[name='USER_PASSWORD']"));
        userName.sendKeys("hr50@cybertekschool.com");
        password.sendKeys("UserUser", Keys.ENTER);
        BrowserUtilities.wait(2);
        WebElement message = driver.findElement(By.cssSelector("[id='feed-add-post-form-tab-message']"));
        message.click();
        BrowserUtilities.wait(1);
        WebElement videoUploadButton = driver.findElement(By.cssSelector("[title='Insert video']"));
        videoUploadButton.click();
        BrowserUtilities.wait(3);
        WebElement videoSours =driver.findElement(By.cssSelector("[placeholder='YouTube or Vimeo video URL']"));
        String videoURL = "https://youtu.be/ERvbs3UjHVU";
        videoSours.sendKeys(videoURL);
        BrowserUtilities.wait(3);
        WebElement saveVideoButton=driver.findElement(By.xpath("//div//input[@type='button' and @value='Save']"));
        saveVideoButton.click();
        BrowserUtilities.wait(1);

        driver.quit();
    }
}
