package com.bitrix.pages;

import com.bitrix.testPackage.AbstractTestBase;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @FindBy(css = "button[id='blog-submit-button-save']")
    private WebElement submitBtn;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement textInputBox;

    @FindBy(xpath = "//body[@contenteditable='true']")
    private WebElement textField;
    //  //*[starts-with(@id,'diskuf-selectdialog')]//table//tbody//tr[3]//td[1]

    @FindBy(xpath = "(//*[starts-with(@id,'diskuf-selectdialog')]//table//tbody//tr[3]//td[1])[1]")
    private WebElement download_from_Extern_Drive;

    @FindBy(className = "popup-window-titlebar-text")
    private WebElement externalUploadWindowMessage;

    //class bx-file-dialog-tab-item-link-text
    @FindBy(xpath = "//div[@class='bx-file-dialog-tab-group']//div")
    private List<WebElement> listOfExternalDrivers;
    ////div[@class='bx-file-dialog-tab-group']//div

    private LoginPage loginPage;

    public void login(){
        loginPage=new LoginPage();
        loginPage.login();
    }


    public void clickAppreciationTab(){
        moreTab.click();
        appreciatTab.click();
    }

    public void uploadFilesAndImages() {

        uploadFiles.click();
        String fileName="dog.png";
        String pathForFile="C:\\Users\\Nikolai\\Desktop\\Bitrix24\\"+fileName;
        uploadFilesImages.sendKeys(pathForFile);

        String actual = uploadedImage.getText();
        System.out.println("Image is uploaded!");
    }

    public void downLoadExternalDrive(){
        uploadFiles.click();
        download_from_Extern_Drive.click();
        List<String> expectedList = Arrays.asList("Box", "Dropbox", "Google Drive", "Office 365", "OneDrive", "Yandex.Disk");
        Assert.assertEquals(list_WebElement_Into_String(listOfExternalDrivers), expectedList);
        System.out.println(expectedList);
        System.out.println(list_WebElement_Into_String(listOfExternalDrivers));
    }

    public List<String> list_WebElement_Into_String(List<WebElement>listWebElements){
         List<String> listOfStrings=new ArrayList<>();
        for (WebElement each:listWebElements) {
            listOfStrings.add(each.getText());
        }
        return listOfStrings;
    }


    public void submitAndSave(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }

    public void typeText(String message){
        driver.switchTo().frame(textInputBox);
        textField.sendKeys(message);
        driver.switchTo().defaultContent();
    }







}
