package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import com.logwire.pages.CartPage;
import com.logwire.pages.CheckoutPage;
import com.logwire.pages.productPage;
import com.logwire.tools.WebdriverTool;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private productPage productPage;

    @Before
    public void setup() {
        cartPage = new CartPage(WebdriverTool.getDriver());
        checkoutPage = new CheckoutPage(WebdriverTool.getDriver());
        productPage = new productPage(WebdriverTool.getDriver());
    }

    @When("je clique sur le bouton de la cart {string}")
    public void je_clique_sur_le_bouton_de_la_cart(String buttonLabel) {
        productPage.allerAuPanier(); 
    }

    @When("je clique sur le bouton du panier {string}")
    public void je_clique_sur_le_bouton_du_panier(String buttonLabel) {
        cartPage.clickCheckoutButton(); 
    }

    @Then("je suis redirige vers le formulaire de paiement")
    public void je_suis_redirige_vers_le_formulaire_de_paiement() {
        checkoutPage = new CheckoutPage(WebdriverTool.getDriver());
        assertTrue(checkoutPage.isCheckoutFormDisplayed(), "Le formulaire de paiement n'est pas affiche");
        }
    @When("je saisis les informations client:")
    public void je_saisis_les_informations_client(io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        String prenom = data.get("prénom");
        String nom = data.get("nom");
        String codePostal = data.get("code postal");

        checkoutPage.SaisirInfoClient(prenom, nom, codePostal);
    }

    @When("je suis redirigé à la page de confirmation")
    public void je_suis_redirige_a_la_page_de_confirmation() {
        checkoutPage.verifyCheckoutComplete();
    }

}
