package org.academy.utils.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class EspnWebDriver {
    private WebDriver driver;
    public EspnWebDriver() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
    }
    public WebDriver getDriver() {
        return driver;
    }
}


