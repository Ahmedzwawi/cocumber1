package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.logwire.pages.productPage;
import com.logwire.tools.WebdriverTool;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProduitsSteps {
    productPage productPage;

    // Verification de la liste des produits
    @Then("je verifie la liste des produits")
    public void je_verifie_la_liste_des_produits() {
        productPage = new productPage(WebdriverTool.getDriver());
        assertTrue(productPage.getProduListElements().size() > 0);
    }

    // Tri des produits par nom
    @When("je trie les produits par nom")
    public void je_trie_les_produits_par_nom() {
        productPage = new productPage(WebdriverTool.getDriver());
        productPage.trierParNom();
    }

    @Then("je vérifie que les produits sont triés par nom")
    public void je_v_rifie_que_les_produits_sont_tri_s_par_nom() {
        List<WebElement> produits = productPage.getProduListElements();
        assertTrue(isSortedByName(produits), "Les produits ne sont pas triés par nom");
    }

    // Ajout d'un produit au panier*******************************************
    @When("je clique sur {string} pour le premier produit")
    public void je_clique_sur_pour_le_premier_produit(String s) {
        productPage = new productPage(WebdriverTool.getDriver());
        productPage.ajouterProduitAuPanier(); // Ajoute le premier produit au panier
    }

    @Then("le produit est ajouté au panier")
    public void le_produit_est_ajout_au_panier() {
        WebElement cartBadge = WebdriverTool.getDriver().findElement(By.cssSelector(".shopping_cart_badge"));
        assertTrue(cartBadge.isDisplayed(), "Le produit n'a pas été ajouté au panier.");
        // Optionnel: Vérifie le nombre d'articles dans le panier
        int nombreArticlesDansPanier = Integer.parseInt(cartBadge.getText());
        assertTrue(nombreArticlesDansPanier > 0, "Le panier est vide.");
    }

    // Supression d'un produit du panier
    @When("je vais dans le panier")
    public void je_vais_dans_le_panier() {
        productPage.allerAuPanier();
    }

    @When("je supprime le premier produit du panier")
    public void je_supprime_le_premier_produit_du_panier() {
        productPage.supprimerProduitDuPanier();
    }

    @Then("le produit est bien supprimé du panier")
    public void le_produit_est_bien_supprim_du_panier() {
        assertTrue(productPage.estProduitSupprime(), "Le produit n'a pas été supprimé correctement du panier.");
    }

    private boolean isSortedByName(List<WebElement> produits) {
        String previousName = "";
        for (WebElement produit : produits) {
            String currentName = produit.getText().trim();
            if (currentName.compareTo(previousName) < 0) {
                return false;
            }
            previousName = currentName;
        }
        return true;
    }

}
