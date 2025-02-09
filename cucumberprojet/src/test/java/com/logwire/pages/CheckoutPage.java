package com.logwire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.logwire.tools.WebdriverTool;

public class CheckoutPage {

    @FindBy(className = "checkout")
    private WebElement checkoutButton;
    @FindBy(className = "checkout_info")
    private WebElement checkoutForm;
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(className = "title")
    private WebElement checkoutCompleteMessage;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void clickCheckoutButton() {
        WebElement checkoutButton = WebdriverTool.getDriver().findElement(By.className("checkout"));
        checkoutButton.click();

        checkoutButton.click();
    }

    public boolean isCheckoutFormDisplayed() {
        return checkoutForm.isDisplayed();
    }

    // form
    public void SaisirInfoClient(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    public void verifyCheckoutComplete() {
        if (!checkoutCompleteMessage.isDisplayed()) {
            throw new AssertionError("La page de confirmation n'est pas affichée !");
        }
    }

    public boolean isCheckoutCompleteMessageDisplayed() {
        return checkoutCompleteMessage.isDisplayed();
    }

}