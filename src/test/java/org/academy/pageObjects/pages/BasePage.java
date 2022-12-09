package org.academy.pageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.academy.utils.web.WebOperations;

/**
 * The Base page class.
 */
public class BasePage extends WebOperations {
    /**
     * Instantiates a new Base page.
     *
     * @param driver the driver
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }
}
