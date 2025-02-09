package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

//locateur
    @FindBy(id = "finish")
    public WebElement finishButton;

    public OverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
//Actions
    public void clickFinish() {
        finishButton.click();
    }
}
