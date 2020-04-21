package com.bitrix.pages;

import com.bitrix.testPackage.AbstractTestBase;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserStory6Page extends PageBase {

    WebDriver driver = AbstractTestBase.getDriver();
    WebDriverWait wait = AbstractTestBase.getWait();
    Actions action = new Actions(driver);

    @FindBy(id="feed-add-post-form-link-text")
    private WebElement moreTab;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and contains(text(),'Appreciation')]")
    private WebElement appreciatTab;

    @FindBy(xpath="//span[@id='bx-b-uploadfile-blogPostForm']")
    private WebElement uploadFiles;

    @FindBy(name = "bxu_files[]")
    private WebElement uploadFilesImages;

    @FindBy(css = "span[class='f-wrap']")
    private WebElement uploadedImage;

    @FindBy(xpath = "(//tbody)[7]")
    private WebElement uploadTable;


    public void clickAppreciationTab(){
        wait.until(ExpectedConditions.visibilityOf(moreTab));
        wait.until(ExpectedConditions.elementToBeClickable(moreTab));
        moreTab.click();
        wait.until(ExpectedConditions.visibilityOf(appreciatTab));
        appreciatTab.click();
    }

    public void uploadFilesAndImages() {
        wait.until(ExpectedConditions.visibilityOf(uploadFiles));
        wait.until(ExpectedConditions.elementToBeClickable(uploadFiles));
        BrowserUtilities.wait(3);
       // action.moveToElement(uploadFiles).click();
        uploadFiles.click();
        wait.until(ExpectedConditions.visibilityOf(uploadTable));
        String fileName="dog.png";
        String pathForFile="C:\\Users\\Nikolai\\Desktop\\Bitrix24\\"+fileName;
        //action.click(uploadFilesImages).sendKeys(pathForFile);
        BrowserUtilities.wait(3);
        uploadFilesImages.sendKeys(pathForFile);
        BrowserUtilities.wait(3);
        String actual = uploadedImage.getText();
        Assert.assertEquals(actual,fileName);
        System.out.println("Image is uploaded!");
    }





}
