package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.logwire.pages.CartPage;
import com.logwire.pages.productPage;
import com.logwire.tools.WebdriverTool;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
    productPage productPage;
    CartPage cartPage;

    @When("jajoute un produit au panier")
    public void j_ajoute_un_produit_au_panier() {
        productPage = new productPage(WebdriverTool.getDriver());// because "this.productPage" is null
        productPage.ajouterProduitAuPanier(); // Ajoute un produit au panier
    }

    @When("je vais sur la page du panier")
    public void je_vais_sur_la_page_du_panier() {
        productPage.allerAuPanier(); 
    }

    @Then("le produit ajouté est bien affiché dans le panier")
    public void le_produit_ajoute_est_bien_affiche_dans_le_panier() {
        cartPage = new CartPage(WebdriverTool.getDriver());
        assertEquals(1, cartPage.getNumberOfItemsInCart(), "Le panier ne contient pas le bon nombre de produits");
    }

   
}
