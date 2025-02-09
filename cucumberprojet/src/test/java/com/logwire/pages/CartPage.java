package com.logwire.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
//locateurs
    @FindBy(css = ".cart_item") 
    private List<WebElement> cartItems;  // Liste des produits dans le panier
    @FindBy(id="checkout") 
    private WebElement checkoutButton;
    // @FindBy(css = ".shopping_cart_badge")  // Localisation du badge du panier
    // public    static WebElement cartBadge;
    
    //  WebElement cartBadge = WebdriverTool.getDriver().findElement(By.cssSelector(".shopping_cart_badge"));
        public CartPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

    //Actions
        // Méthode pour obtenir le size de liste des produits dans le panier
        public int getNumberOfItemsInCart() {
            return cartItems.size();
        }
        public void clickCheckoutButton() {
            checkoutButton.click();
        }
    
}
