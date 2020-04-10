package com.bitrix.pages.pageBase;

import com.bitrix.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {

   public PageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
