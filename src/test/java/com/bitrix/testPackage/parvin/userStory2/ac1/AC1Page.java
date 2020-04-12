package com.bitrix.testPackage.parvin.userStory2.ac1;

import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AC1Page {

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

    public AC1Page() {
        PageFactory.initElements(driver, this);
    }
}
