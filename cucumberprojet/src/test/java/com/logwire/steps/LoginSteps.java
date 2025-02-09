package com.logwire.steps;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;
import com.logwire.pages.LoginPage;
import com.logwire.tools.WebdriverTool;

public class LoginSteps {

    LoginPage loginPage;  

    @Given("je suis sur {string}")
    public void je_suis_sur(String s) {        
        WebdriverTool.getDriver().get(s);
        this.loginPage = new LoginPage(WebdriverTool.getDriver());
    }
    @When("je saisis le username {string}")
    public void je_saisis_le_username(String s) {       
         this.loginPage.saisirUsername(s);
    }


    @When("je saisi le password {string}")
    public void je_saisi_le_password(String s) {        
        this.loginPage.saisirPassword(s);
    }

    @When("je clique sur le bouton {string}")
    public void je_clique_sur_le_bouton(String s) {       
         this.loginPage.clickboutton();
    }

    @Then("je suis redirigé au dashbord")
    public void je_suis_redirig_au_dashbord() {
        assertTrue(WebdriverTool.getDriver().getCurrentUrl().contains("inventory"));        
    }

    @Then("un message derreur saffiche")
    public void un_message_derreur_saffiche() {
        assertTrue(this.loginPage.getMessageError().isDisplayed());
    }

    @Then("un message derreur de compte blocage saffiche")
    public void un_message_derreur_de_compte_blocage_saffiche() {
        assertTrue(this.loginPage.getMessageError().isDisplayed());
    }

    @Then("la connexion est lente mais réussie")
    public void la_connexion_est_lente_mais_r_ussie() {
        assertTrue(WebdriverTool.getDriver().getCurrentUrl().contains("inventory"));
        System.err.println("la connexion est lente mais réussie");  
      }

    
}
