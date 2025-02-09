package com.logwire.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class productPage {
//locateurs

    @FindBy(css = ".inventory_item")
    private List<WebElement> produListElements;
    @FindBy(css = ".product_sort_container")  // Localisation du menu déroulant de tri
    private WebElement sortDropdown;
    @FindBy(css = "option[value='az']")  // Localisation de l'option de tri par nom
    private WebElement sortByNameOption;
    @FindBy(css = ".btn_inventory")  // Localisation du bouton addPanier
    private WebElement addToCartButton;
    @FindBy(css = ".shopping_cart_link")  // Localisation de l'icône du panier
    private static WebElement cartIcon;
    @FindBy(css = ".cart_button")  // Localisation du bouton de suppression
    private WebElement removeButton;
    @FindBy(css = ".shopping_cart_badge")  // Localisation du badge du panier
    private WebElement cartBadge;
    
    // Constructeur
    public productPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    //Actions
    public List<WebElement> getProduListElements() {
        return this.produListElements;
    }
        // Méthode pour trier les produits par nom
    public void trierParNom() {
        sortDropdown.click();
        sortByNameOption.click();
    }
        // Méthode pour ajouter un produit au panier
    public void ajouterProduitAuPanier() {
        addToCartButton.click();
    }
    public static void allerAuPanier() {
        cartIcon.click();     
   }
    public void supprimerProduitDuPanier() {
        removeButton.click();      
    }
    public boolean estProduitSupprime() {
        try {
            // Vérifie si le bouton de suppression est absent (produit supprimé)
            return cartBadge.getText().equals("0");
        } catch (Exception e) {
            return true; // Si l'élément n'est pas trouvé, on considère que le panier est vide
        }
    }
    

}
