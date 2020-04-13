package com.bitrix.testPackage.parvin.userStory2;

import com.bitrix.testPackage.AbstractTestBase;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class UserStory2Test extends AbstractTestBase {

    /**
     * User Story:
     * As a user, I should be able to assign
     * tasks by clicking on Task tab under Active Stream.
     * To enable screen reader support, press ⌘+Option+Z To learn about keyboard shortcuts, press ⌘slash
     */
    UserStory2Page userStory2Page;

    /**
     * AC1:
     * User should be able to click on "High Priority" checkbox
     * to set the current task to a top priority task.
     */
    @Test(dataProvider = "credentialsFromExcel")
    public void verifyHighPriorityCheckboxClicked(String usernameValue, String passwordValue) {

        test = reports.createTest("Verify AC1 as userName " + usernameValue);
        loginPage.login(usernameValue, passwordValue);

        test.info("Login as " + usernameValue);
        Assert.assertEquals(loginPage.getPageLogoText(), "CRM");
        test.pass("Page logo CRM was verified");

        userStory2Page = new UserStory2Page();

        /**
         ** AC1. User should be able to click on "High Priority" checkbox to set the current task to a top priority task.
         */
        test = reports.createTest("Verify taskTab is visible");
        wait.until(ExpectedConditions.visibilityOf(userStory2Page.taskTab));
        Assert.assertEquals(userStory2Page.getTaskTabText(), "TASK");
        test.pass("taskTab is verified");

        userStory2Page.taskTab.click();
        test = reports.createTest("Verify HighPriorityCheckBox is visible");
        wait.until(ExpectedConditions.visibilityOf(userStory2Page.highPriorityCheckBox));
        Assert.assertEquals(userStory2Page.getHighPriorityCheckBox(), "High Priority");
        test.pass("HighPriorityCheckBox is verified");

        test = reports.createTest("Verify HighPriorityCheckBox is enabled");
        userStory2Page.highPriorityCheckBox.click();
        Assert.assertTrue(userStory2Page.highPriorityCheckBox.isEnabled());
        test.pass("HighPriorityCheckBox is enabled");

        /**
         * AC2. User should be able to click on Visual Editor and see the editor text-bar displays on top of the
         * message box
         */
        test = reports.createTest("Verify VisualEditor is visible");
        Assert.assertEquals(userStory2Page.getVisualEditorValue(), "Visual editor");
        test.pass("VisualEditor is visible");

        test = reports.createTest("Verify VisualEditor is enabled");
        userStory2Page.visualEditor.click();
        Assert.assertTrue(userStory2Page.visualEditor.isEnabled());
        test.pass("VisualEditor is enabled");

        test = reports.createTest("Verify Editor Text-Bar is displayed");
        Assert.assertTrue(userStory2Page.editorTextBar.isDisplayed());
        test.pass("Editor Text-Bar is displayed");

        /**
         * AC3. User should be able to click on upload files icon to upload files and pictures from local disks,
         * download from external drive, select documents from bixtrix24, and create files to upload.
         */
        test = reports.createTest("Verify Upload Files Icon is visible");
        Assert.assertEquals(userStory2Page.getUploadFilesIconTitle(), "Upload files");
        test.pass("Upload Files Icon is visible");

        test = reports.createTest("Verify Upload Files Icon is clicked");
        userStory2Page.uploadFilesIcon.click();
        Assert.assertTrue(userStory2Page.visualEditor.isEnabled());
        test.pass("Upload Files Icon is clicked");

        /**
         * AC4. User should be able to create a quote by clicking on the Comma icon.
         */
        test = reports.createTest("Verify Comma icon is visible");
        Assert.assertEquals(userStory2Page.getCommaIconTitle(), "Quote text");
        test.pass("Comma icon is visible");

        test = reports.createTest("Verify Comma Icon is clicked");
        userStory2Page.commaIcon.click();
        Assert.assertTrue(userStory2Page.commaIcon.isEnabled());
        test.pass("Comma Icon is clicked");

        /**
         * AC5. User should be able to add mention by clicking on the Add mention icon and
         * select contacts from the lists provided in dropdown.
         **/
        test = reports.createTest("Verify Add Mention Icon is visible");
        Assert.assertEquals(userStory2Page.getAddMentionIconTitle(), "Add mention");
        test.pass("Add Mention Icon is visible");

        test = reports.createTest("Verify Add Mention Icon is clicked");
        userStory2Page.addMentionIcon.click();
        Assert.assertTrue(userStory2Page.addMentionIcon.isEnabled());
        test.pass("Add Mention Icon is clicked");

        /**
         * AC6. User should be able to attach link by clicking on the link icon.
         **/
        test = reports.createTest("Verify Link Icon is visible");
        Assert.assertEquals(userStory2Page.getLinkIconTitle(), "Link");
        test.pass("Link Icon is visible");

        test = reports.createTest("Verify Link Icon is clicked");
        userStory2Page.linkIcon.click();
        Assert.assertTrue(userStory2Page.linkIcon.isEnabled());
        test.pass("Link Icon is clicked");

        // to close link attach dialog box.
        driver.findElement(By.xpath("//span[@class='bx-core-adm-icon-close']")).click();

        /**
         * AC7. User should be able to click on "Checklist" to create checklists items(Things to do).
         * User can add a checklist item by clicking on add button or check mark.
         * User can add separator lines between checklist items.
         * User can delete a checklist item by clicking on x mark.
         **/
        test = reports.createTest("Verify Checklist Icon is available");
        wait.until(ExpectedConditions.visibilityOf(userStory2Page.checklistIcon));
        BrowserUtilities.wait(2);
        Assert.assertEquals(userStory2Page.getChecklistIconName(), "Checklist");
        test.pass("Checklist Icon is available");

        test = reports.createTest("Verify Checklist Icon is clicked");
        userStory2Page.checklistIcon.click();
        Assert.assertTrue(userStory2Page.checklistIcon.isEnabled());
        test.pass("Checklist Icon is clicked");

        test = reports.createTest("Verify Add Button is clickable");
        userStory2Page.addButton.click();
        Assert.assertTrue(userStory2Page.addButton.isEnabled());
        test.pass("Add Button is clickable");

        test = reports.createTest("Verify Check Mark is clickable");
        userStory2Page.checkMark.click();
        Assert.assertTrue(userStory2Page.checkMark.isEnabled());
        test.pass("Check Mark is clickable");

        test = reports.createTest("Verify Separator is clickable");
        userStory2Page.separator.click();
        Assert.assertTrue(userStory2Page.separator.isEnabled());
        test.pass("Separator is clickable");

        test = reports.createTest("Verify x mark is clickable");
        userStory2Page.xMark.click();
        Assert.assertTrue(userStory2Page.xMark.isEnabled());
        test.pass("x mark is clickable");

        /**
         * AC8. User can assign the tasks to employees by clicking on Add More and
         * selecting contact from E-mail user, Employees and Departments and Recent contact lists.
         * Employees can be added in different assignment categories: Created By, Participants and Observer.
         */
        test = reports.createTest("Verify Add More is clickable");
        wait.until(ExpectedConditions.visibilityOf(userStory2Page.addMore));
        userStory2Page.addMore.click();
        Assert.assertTrue(userStory2Page.addMore.isEnabled());
        test.pass("Add more is clickable");

        test = reports.createTest("Verify E-mail users is selectable");
        wait.until(ExpectedConditions.visibilityOf(userStory2Page.emailUsers));
        Assert.assertTrue(userStory2Page.emailUsers.isDisplayed());
        test.pass("E-mail Users is selectable");

        test = reports.createTest("Verify Employees and Departments is selectable");
        Assert.assertTrue(userStory2Page.empAndDept.isDisplayed());
        test.pass("Employees and Department is selectable");

        test = reports.createTest("Verify Recent is selectable");
        Assert.assertTrue(userStory2Page.recent.isDisplayed());
        test.pass("Recent is selectable");

        //to close window by clicking on x mark
        driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();

        test = reports.createTest("Verify Created By is selectable");
        Assert.assertTrue(userStory2Page.createdBy.isDisplayed());
        test.pass("Created By is selectable");

        test = reports.createTest("Verify Participants is selectable");
        Assert.assertTrue(userStory2Page.participants.isDisplayed());
        test.pass("Participants is selectable");

        test = reports.createTest("Verify Observers is selectable");
        Assert.assertTrue(userStory2Page.observers.isDisplayed());
        test.pass("Observers is selectable");

        /**
         * AC9. User can add Deadline, Time Planning by using date pickers.
         */
        test = reports.createTest("Verify Deadline is displayed");
        wait.until(ExpectedConditions.visibilityOf(userStory2Page.deadline));
        Assert.assertTrue(userStory2Page.deadline.isDisplayed());
        test.pass("Deadline is displayed");

        test = reports.createTest("Verify Deadline Box is clickable");
        userStory2Page.deadlineBox.click();
        Assert.assertTrue(userStory2Page.deadline.isEnabled());
        test.pass("Deadline Box is clicked");

        test = reports.createTest("Verify Timeline is displayed");
        Assert.assertTrue(userStory2Page.timePlanning.isDisplayed());
        test.pass("Timeline is available");

        test = reports.createTest("Verify Timeline is clicked");
        userStory2Page.timePlanning.click();
        Assert.assertTrue(userStory2Page.timePlanning.isEnabled());
        test.pass("Timeline is clicked");


        test = reports.createTest("Verify date pickers are available and clickable");
        userStory2Page.startDatePicker.click();
        Assert.assertTrue(userStory2Page.startDatePicker.isEnabled());
        userStory2Page.finishDatePicker.click();
        Assert.assertTrue(userStory2Page.finishDatePicker.isEnabled());
        test.pass("Date pickers are available and clicked");

        /**
         * AC10. User can click on More to specify the task details.
         */
        test = reports.createTest("Verify More Task Details is clickable");
        userStory2Page.moreTaskDetails.click();
        Assert.assertTrue(userStory2Page.moreTaskDetails.isEnabled());
        test.pass("More Task Details is clicked");

    }

    @DataProvider
    public Object[][] credentialsFromExcel() {

        String path = "BitrixCredentials.xlsx";
        String spreadSheet = "Credentials";

        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        return excelUtil.getDataArray();
    }


}
