package com.bitrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserStory6Page extends PageBase {

    @FindBy(id="feed-add-post-form-link-text")
    private WebElement moreTab;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and contains(text(),'Appreciation')]")
    private WebElement appreciatTab;





}
