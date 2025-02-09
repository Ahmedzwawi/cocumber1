package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    
    //Locateurs
   @FindBy(name = "user-name")
   private WebElement usernameField;
    @FindBy(name = "password")
    private  WebElement passwordField;
    @FindBy(id ="login-button") 
    private WebElement loginButton;
    @FindBy(className = "error")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    //Actions
    public void saisirUsername(String username) {
    usernameField.sendKeys(username);
    }
    public void saisirPassword(String password) {
    passwordField.sendKeys(password);
    }
    public void clickboutton() {
    loginButton.click();    
    }
    public WebElement getMessageError() {
    return this.errorMessage;
    }

    
}
