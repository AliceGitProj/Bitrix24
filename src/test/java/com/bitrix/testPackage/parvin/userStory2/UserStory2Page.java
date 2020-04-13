package com.bitrix.testPackage.parvin.userStory2;

import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserStory2Page {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(xpath = "//span[text()='Task']")
    protected WebElement taskTab;

    public String getTaskTabText() {
        return taskTab.getText();
    }

    @FindBy(xpath = "//div[@class='task-info-panel-important']")
    protected WebElement highPriorityCheckBox;

    public String getHighPriorityCheckBox() {
        return highPriorityCheckBox.getText();
    }

    @FindBy(id = "lhe_button_editor_task-form-lifefeed_task_form")
    protected WebElement visualEditor;

    public String getVisualEditorValue() {
        return visualEditor.getAttribute("title");
    }

    @FindBy(id = "bx-html-editor-tlbr-lifefeed_task_form")
    protected WebElement editorTextBar;

    @FindBy(id = "bx-b-uploadfile-task-form-lifefeed_task_form")
    protected WebElement uploadFilesIcon;

    public String getUploadFilesIconTitle() {
        return uploadFilesIcon.getAttribute("title");
    }

    @FindBy(xpath = "//span[@id='bx-b-quote-task-form-lifefeed_task_form']//span")
    protected WebElement commaIcon;

    public String getCommaIconTitle() {
        return commaIcon.getAttribute("title");
    }

    @FindBy(id = "bx-b-mention-task-form-lifefeed_task_form")
    protected WebElement addMentionIcon;

    public String getAddMentionIconTitle() {
        return addMentionIcon.getAttribute("title");

    }

    @FindBy(xpath = "//span[@id='bx-b-link-task-form-lifefeed_task_form']//span")
    protected WebElement linkIcon;

    public String getLinkIconTitle() {
        return linkIcon.getAttribute("title");
    }

    @FindBy(xpath = "//span[text()='Checklist']")
    protected WebElement checklistIcon;

    public String getChecklistIconName() {
        return checklistIcon.getText();
    }

    @FindBy(xpath = "//span[text()='add']")
    protected WebElement addButton;

    @FindBy(xpath = "//span[contains(@class,'js-id-checklist-is-form-s')]")
    protected WebElement checkMark;

    @FindBy(xpath = "//span[text()='separator']")
    protected WebElement separator;

    @FindBy(xpath = "//span[contains(@class,'js-id-checklist-is-form-c')]")
    protected WebElement xMark;

    @FindBy(xpath = "//*[contains(@id,'bx-component-scope-lifefeed_task_form-r')]//a[contains(text(),'Add ')]")
    protected WebElement addMore;

    @FindBy(xpath = "//a[text()='E-mail users']")
    protected WebElement emailUsers;

    @FindBy(xpath = "//a[contains(@id,'destDepartmentTab')]")
    protected WebElement empAndDept;

    @FindBy(xpath = "//a[contains(@id,'destLastTab')]")
    protected WebElement recent;

    @FindBy(xpath = "//*[text()='Created by'][contains(@class,'task-d')]")
    protected WebElement createdBy;

    @FindBy(xpath = "//*[text()='Participants'][contains(@class,'task-d')]")
    protected WebElement participants;

    @FindBy(xpath = "//*[text()='Observers'][contains(@class,'task-d')]")
    protected WebElement observers;

    @FindBy(xpath = "//span[text()='Deadline']")
    protected WebElement deadline;

    @FindBy(xpath = "//span[contains(@class,'task-options-de')]//input[@class='task-options-inp']")
    protected WebElement deadlineBox;

    @FindBy(xpath = "//span[text()='Time planning']")
    protected WebElement timePlanning;

    @FindBy(xpath = "//div[contains(@class,'task-options-item-open-inner t')]//div[2]//span[1]//input[1]")
    protected WebElement startDatePicker;

    @FindBy(xpath = "//div[@class='task-options task-options-main']//div[4]//span[1]//input[1]")
    protected WebElement finishDatePicker;

    @FindBy(xpath = "//div[@class='task-additional-alt-more']")
    protected WebElement moreTaskDetails;


    public UserStory2Page() {
        PageFactory.initElements(driver, this);
    }
}
