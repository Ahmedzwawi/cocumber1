package com.logwire.hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.logwire.tools.WebdriverTool;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
     //@Before
   //  public void beforEachScenario() {
   //     WebdriverTool.setupDriver();
   //  }

   @Before
   public void beforeEachScenario() {
       String browser = getBrowserFromProperties(); 
       WebdriverTool.setupDriver(browser);  
   }

    @After
    public void afterEachScenario() {
       WebdriverTool.tearDown();
    }
    // Fonction pour récupérer le navigateur depuis un fichier de propriétés
    private String getBrowserFromProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/cucumber.properties")) {
            properties.load(input);
            return properties.getProperty("browser", "chrome");  // Valeur par défaut : chrome
        } catch (IOException e) {
            e.printStackTrace();
            return "chrome";  // Si problème, use Chrome par défaut
        }
    }
    
}
