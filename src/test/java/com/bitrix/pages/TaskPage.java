package com.bitrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TaskPage extends PageBase {

    @FindBy(id = "tasks-buttonAdd")
    private WebElement newTaskButton;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    private WebElement Tasks;



   public void clickOnTask() {
       wait.until(ExpectedConditions.visibilityOf(Tasks)).click();

   }

   public void createNewTask(){
       wait.until(ExpectedConditions.visibilityOf(newTaskButton)).click();


   }

}
