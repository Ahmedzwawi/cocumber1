package com.logwire.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverTool {

    static public WebDriver driver;

    // static public void setupDriver() {

    //     // String path = System.getProperty("user.dir");
    //     driver = new ChromeDriver();

    // }
       static public void setupDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new WebDriverException("Browser not supported");
        }
    }

    static public WebDriver getDriver() {
        return driver;
    }

    static public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
