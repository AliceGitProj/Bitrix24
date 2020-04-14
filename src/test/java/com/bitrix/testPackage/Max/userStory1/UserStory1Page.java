package com.bitrix.testPackage.Max.userStory1;

import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserStory1Page {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    //===========   Story - 1  ===================
    @FindBy(css = "[id='feed-add-post-form-tab-message']")
    protected WebElement message;

    @FindBy(css = "[id='bx-b-uploadfile-blogPostForm']")
    protected WebElement uploadEnvelop;

    @FindBy(xpath = "(//table//tbody//tr//td[@class='diskuf-selector wd-fa-add-file-light-cell wd-fa-add-file-from-main'])[1]")
    protected WebElement uploadFileAndImages;

    @FindBy(xpath = "(//span[text()='Download from external drive'])[1]")
    protected WebElement downloadFromExternalDrive;


    //===========   Story - 3  ===================

    @FindBy(css = "[title='Link']")
    protected WebElement linkButton;

    @FindBy(css = "[placeholder='Link text']")
    protected WebElement linkText;

    @FindBy(css = "[placeholder='Link URL']")
    protected WebElement linkURL;

    @FindBy(css = "[class='adm-btn-save']")
    protected WebElement saveButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    protected WebElement iframe;

    @FindBy(xpath = "(//body[@contenteditable='true']//a[@href])[1]")
    protected WebElement wordsInsideFrame;


    //===========   Story - 4  ===================

    @FindBy(css = "[title='Insert video']")
    protected WebElement videoUploadButton;

    @FindBy(css = "[placeholder='YouTube or Vimeo video URL']")
    protected WebElement videoSours;

    @FindBy(xpath = "//div//input[@type='button' and @value='Save']")
    protected WebElement saveVideoButton;




    public UserStory1Page() {
        PageFactory.initElements(driver, this);
    }
}
