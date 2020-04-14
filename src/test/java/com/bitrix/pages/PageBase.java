package com.bitrix.pages;

import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public abstract class PageBase {

    protected WebDriver driver=Driver.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,20);

   public PageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }




    public void navigateTo(String tabName ){
       String tabNameXpath="//span[@class='menu-item-link-text' and contains(text(),'"+tabName+"')]";

        WebElement tabElement=driver.findElement(By.xpath(tabNameXpath));
        Actions actions=new Actions(driver);
        BrowserUtilities.wait(4);
        actions.moveToElement(tabElement).pause(2000).click().build().perform();



    }

}
