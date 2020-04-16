package com.bitrix.pages;

import com.bitrix.testPackage.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;

public class PollPage extends PageBase {

    WebDriverWait wait = TestBase.getWait();
    WebDriver driver = TestBase.getDriver();
    Actions actions = TestBase.getActions();


    @FindBy(id = "feed-add-post-form-tab-vote")
    private WebElement poll;

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    private WebElement uploadFilesIcon;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']//i")
    private WebElement linkIcon;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-quote']//i")
    private WebElement quoteTextIcon;

    @FindBy(xpath= "(//span[@class='feed-add-post-form-but feed-add-mention'])[1]")
    private WebElement addMentionIcon;


    @FindBy(xpath = "(//tbody)[7]")
    private WebElement uploadTable;

    @FindBy(xpath = "(//tbody)[6]")
    private WebElement uploadedFilesTable;

    @FindBy(xpath = "(//input[@class = \"diskuf-fileUploader wd-test-file-light-inp \"])[1]")
    private WebElement uploadFilesAndImages;

    @FindBy(xpath = "(//span[@class = \"wd-fa-add-file-light\"])//span[text() = \"Select document from Bitrix24\"]")
    private WebElement uploadSelectDocumentFromBitrix24;

    @FindBy(xpath = "//div[@class = \"popup-window popup-window-content-white popup-window-content-no-paddings popup-window-with-titlebar\"]")
    private WebElement uploadSelectDocumentFromBitrix24Frame;

    @FindBy(xpath = "(//div[@class = \"bx-file-dialog-tab-item\"])[3]")
    private WebElement uploadSelectDocumentFromBitrix24_SalesMarketing;

    @FindBy(xpath = "//span[@title = \"Name: Marketing and advertising\"]")
    private WebElement uploadSelectDocumentFromBitrix24_SalesMarketing_MarketingAndAdvertising;

    @FindBy(xpath = "//span[@title = \"Name: Logo.gif\"]")
    private WebElement uploadSelectDocumentFromBitrix24_SalesMarketing_MarketingAndAdvertising_Logo;

    @FindBy(xpath = "//span[@class = \"popup-window-button popup-window-button-accept\"]")
    private WebElement uploadSelectDocumentFromBitrix24Frame_SelectDocument;

    @FindBy(xpath = "(//span[@class = \"wd-fa-add-file-light-title-text\"])[2]")
    private WebElement downloadFromExternalDrive;

    @FindBy(xpath = "//div[@class='bx-file-dialog-tab-group']//div")
    private List<WebElement> downloadFromExternalDrive_ListOfDrives;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-link popup-window-button-link-cancel']")
    private WebElement downloadFromExternalDrive_Cancel;

    @FindBy(xpath = "(//span[@class='wd-fa-add-file-editor-file'])[2]//a[1]")
    private WebElement createUsingGoogleDocs_Document; //*[@class='bx-core bx-no-touch bx-no-retina bx-chrome']

    @FindBy(xpath = "//*[@class='bx-core bx-no-touch bx-no-retina bx-chrome']")
    private WebElement createUsingGoogleDocs_DocumentFrame;

    @FindBy(xpath = "//div[@id='error']//div//span")
    private WebElement createUsingGoogleDocs_DocumentText;

    @FindBy(xpath = "//a[@id='bx-destination-tag']")
    private WebElement addMoreUsers;

    @FindBy(xpath = "//div[contains(text(),'Help')]")
    private WebElement addMoreUsers_Recent_Help;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    private WebElement link_text;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    private WebElement link_addingLink;

    @FindBy(xpath = "//input[@id='undefined']")
    private WebElement link_saveButton;

    @FindBy(xpath = "//a[text() = \"Employees and departments\"]")
    private WebElement addMention_EmployeesAndDepts;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-employee-name'][contains(text(),'Help')]")
    private WebElement addMention_EmployeesAndDepts_Help;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text'][contains(text(),'Help')]")
    private WebElement addMention_EmployeesAndDepts_Help_Added;

    @FindBy(xpath = "//span[@id='lhe_button_editor_blogPostForm']")
    private WebElement visualEditorIcon;

    @FindBy(xpath = "//div[@id='bx-html-editor-tlbr-cnt-idPostFormLHE_blogPostForm']")
    private WebElement visualEditorIconToolbar;

    @FindBy(xpath = "//span[@id='lhe_button_title_blogPostForm']")
    private WebElement topicIcon;

    @FindBy(xpath = "//input[@id='POST_TITLE']")
    private WebElement topicHeadInput;

    @FindBy(xpath = "//div[@id='divoPostFormLHE_blogPostForm']//span[@class='feed-add-post-form-but-cnt feed-add-videomessage'][contains(text(),'Record Video')]")
    private WebElement recordVideoIcon;

    @FindBy(id = "popup-window-content-bx-popup-videomessage-popup")
    private WebElement recordVideoPopupText;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-link popup-window-button-decline']")
    private WebElement recordVideoClose;


//----------------------------------------------------------------------------------------------------------------------

    public void clickPollTab() {
        poll.click();
    }

    public void clickUploadFilesIcon() {
        wait.until(ExpectedConditions.visibilityOf(uploadFilesIcon));
        wait.until(ExpectedConditions.elementToBeClickable(uploadFilesIcon));
        uploadFilesIcon.click();
    }

    public void uploadFilesAndImages() {
        wait.until(ExpectedConditions.visibilityOf(uploadTable));
        uploadFilesAndImages.sendKeys(System.getProperty("user.dir") + "/README.md");
        Assert.assertEquals(getDataFromUploadedFilesTable(1, 1), "README.md");
    }

    public void uploadSelectDocumentFromBitrix24() {
        uploadSelectDocumentFromBitrix24.click();
        wait.until(ExpectedConditions.visibilityOf(uploadSelectDocumentFromBitrix24Frame));

        uploadSelectDocumentFromBitrix24_SalesMarketing.click();
        wait.until(ExpectedConditions.visibilityOf(uploadSelectDocumentFromBitrix24_SalesMarketing_MarketingAndAdvertising));

        uploadSelectDocumentFromBitrix24_SalesMarketing_MarketingAndAdvertising.click();
        wait.until(ExpectedConditions.visibilityOf(uploadSelectDocumentFromBitrix24_SalesMarketing_MarketingAndAdvertising_Logo));

        uploadSelectDocumentFromBitrix24_SalesMarketing_MarketingAndAdvertising_Logo.click();

        uploadSelectDocumentFromBitrix24Frame_SelectDocument.click();
        Assert.assertEquals(getDataFromUploadedFilesTable(2, 1), "Logo.gif");
    }

    public void downloadFromExternalDrive() {
        downloadFromExternalDrive.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(downloadFromExternalDrive_ListOfDrives));
        List<String> expectedList = Arrays.asList("Box", "Dropbox", "Google Drive", "Office 365", "OneDrive", "Yandex.Disk");
        Assert.assertEquals(getTextFromListOfElements(downloadFromExternalDrive_ListOfDrives), expectedList);
        downloadFromExternalDrive.click();
    }

    public void createUsingGoogleDocs() {
        createUsingGoogleDocs_Document.click();
        String parentHandle = driver.getWindowHandle();
        ;
        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
        }
        wait.until(ExpectedConditions.visibilityOf(createUsingGoogleDocs_DocumentText));
        Assert.assertEquals(createUsingGoogleDocs_DocumentText.getText(), "The social networking service Google Docs is not configured. Please contact your Bitrix24 administrator.");
        driver.switchTo().window(parentHandle);
    }

    public void addMoreUsersFromRecent() {
        addMoreUsers.click();
        wait.until(ExpectedConditions.visibilityOf(addMoreUsers_Recent_Help));
        addMoreUsers_Recent_Help.click();
        Assert.assertEquals(addMoreUsers_Recent_Help.getText().trim(), "Help");

    }

    public void attachedLink() {
        linkIcon.click();
        wait.until(ExpectedConditions.visibilityOf(link_text));
        link_text.sendKeys("Youtube");
        link_addingLink.sendKeys("https://www.youtube.com/results?search_query=miyagi+kosandra");
        link_saveButton.click();
    }

    public void createdQuote(){
        String parentFrame = driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOf(quoteTextIcon));
        quoteTextIcon.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//blockquote[@class='bxhtmled-quote']")).sendKeys("new quote is created");
        driver.switchTo().defaultContent();
    }

    public void addedMention(){
        wait.until(ExpectedConditions.visibilityOf(addMentionIcon));
        addMentionIcon.click();
        try {
            Thread.sleep(3000);
            addMention_EmployeesAndDepts.click();
        } catch (Exception e) {
            e.printStackTrace();
            driver.findElement(By.xpath("//a[text() = \"Employees and departments\"]")).click();
        }

        wait.until(ExpectedConditions.visibilityOf(addMention_EmployeesAndDepts_Help));
        addMention_EmployeesAndDepts_Help.click();
        wait.until(ExpectedConditions.visibilityOf(addMention_EmployeesAndDepts_Help_Added));
        Assert.assertEquals(addMention_EmployeesAndDepts_Help_Added.getText().trim(), "Help");
    }

    public void visualEditorClickability() {
        wait.until(ExpectedConditions.visibilityOf(visualEditorIcon));
        visualEditorIcon.click();
        wait.until(ExpectedConditions.visibilityOf(visualEditorIconToolbar));
        Assert.assertTrue(visualEditorIconToolbar.isDisplayed());
        visualEditorIcon.click();
    }

    public void topicIcon() {
        wait.until(ExpectedConditions.visibilityOf(topicIcon));
        topicIcon.click();
        wait.until(ExpectedConditions.visibilityOf(topicHeadInput));
        Assert.assertTrue(topicHeadInput.isDisplayed());
        Assert.assertEquals(topicHeadInput.getAttribute("placeholder"), "Topic");
        topicIcon.click();
    }

    public void recordIcon() {
        wait.until(ExpectedConditions.visibilityOf(recordVideoIcon));
        recordVideoIcon.click();

        wait.until(ExpectedConditions.visibilityOf(recordVideoPopupText));
        Assert.assertEquals(recordVideoPopupText.getText(), "You have to allow access to your camera and microphone to record a video.");
        recordVideoClose.click();
    }

    public void question() {
        wait.until(ExpectedConditions.visibilityOf(questionHead));
        questionHead.sendKeys("question");
        driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys("answer");
        driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys("answer 2");
        driver.findElement(By.xpath("//input[@id='answer_0__2_']")).sendKeys("answer 3");
        allowMultipleChoices.click();
        sendButton.click();
        wait.until(ExpectedConditions.urlToBe("https://login1.nextbasecrm.com/stream/?login=yes"));
        Assert.assertEquals(quesionNameInStream.getText(), "question");
        System.out.println(answersInStream.getText());


        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//input[@id='question_0']")
    private WebElement questionHead;

    @FindBy(className = "vote-checkbox")
    private WebElement allowMultipleChoices;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;

    @FindBy(xpath = "//ol[@class = \"bx-vote-question-list\"]//li//div")
    private WebElement quesionNameInStream;

    @FindBy(xpath = "//ol[@class = \"bx-vote-question-list\"]//li//table//tbody")
    private WebElement answersInStream;


    //utils ------------------------------------------------------------------------------------------------------------

    private String getDataFromUploadedFilesTable(int row, int column) {
        return driver.findElement(By.xpath("(//tbody[@class='" + uploadedFilesTable.getAttribute("class") + "'])[1]//tr[" + row + "]//td[" + column + "]")).getText();
    }

    private List<String> getTextFromListOfElements(List<WebElement> list) {
        List<String> temp = new ArrayList<>();
        for (WebElement each : list) {
            temp.add(each.getText());
        }
        return temp;
    }


}
