package org.academy.utils.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * The Espn web driver.
 */
public class EspnWebDriver {
    private WebDriver driver;

    /**
     * Instantiates a new Espn web driver.
     */
    public EspnWebDriver() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }
}


