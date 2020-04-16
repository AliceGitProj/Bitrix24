package com.bitrix.pages;

import com.bitrix.testPackage.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

   public PageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
