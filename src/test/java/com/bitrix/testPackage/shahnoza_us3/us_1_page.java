package com.bitrix.testPackage.shahnoza_us3;

import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class us_1_page {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);
    /**
     *  U_S #3
     *  "3. As a user, I should be able to create
     * events by clicking on Event tab under Activity Stream."
     *
     *
     *  TC 1.
     * User should be able to click on upload files icon to upload files
     * and pictures from local disks,
     * download from external drive,
     * select documents from bixtrix24,
     * and create files to upload.
     */

    @FindBy(xpath = "//input[name='bxu_files[]']" )
    protected WebElement fileImageUpload;

    @FindBy(xpath = "//span[text()='Download from external drive']")
    protected WebElement externalDrive;

    @FindBy(xpath = "//span[text()='Select document from Bitrix24']")
    protected WebElement selectDocument;

    @FindBy(xpath = "//span[text()='Google Docs']")
    protected WebElement createFile;


}

// 2. User should be able to attach link by clicking on the link icon.
// 4. User should be able to insert videos by clicking on the video icon and entering the video URL.
// 5. User should be able to create a quote by clicking on the Comma icon.
// 6. User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
// 7. User should be able to add Event start and ending date and time, and specify the time zone.
// 8. User should be able to set reminder by entering the timeing.
// 9. User should be able to select event location from dropdown.
// 10. User should be able to add attendees by selecting contacts individually or adding grups and departments.
// 11. User should be able to click on More to specify the event details.
//

