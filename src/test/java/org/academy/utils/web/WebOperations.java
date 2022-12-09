package org.academy.utils.web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * The Web operations class.
 */
public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor method
     *
     * @param driver the driver
     */
    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20L);
        initElements(driver, this);
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Click element.
     *
     * @param element the element
     */
    public void clickElement(WebElement element) {
        waitForVisibility(element);
        waitForClickable(element);
        element.click();
    }

    /**
     * Hover the mouse on element.
     *
     * @param element the element
     */
    public void hoverTheMouseOnElement(WebElement element) {
        this.waitForVisibility(element);
        Actions action = new Actions(this.getDriver());
        action.moveToElement(element).perform();
    }

    /**
     * Type on input.
     *
     * @param element the element
     * @param text    the text
     */
    public void typeOnInput(WebElement element, String text) {
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    /**
     * Wait for visibility.
     *
     * @param element the element
     */
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Wait for clickable.
     *
     * @param element the element
     */
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Scroll to bottom.
     */
    public void scrollToBottom(){
        new Actions(getDriver()).sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    /**
     * Wait for attribute value.
     *
     * @param element   the element
     * @param attribute the attribute
     * @param value     the value
     */
    public void waitForAttributeValue(WebElement element, String attribute, String value) {
        this.wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    /**
     * Wait for invisibility.
     *
     * @param element the element
     */
    public void waitForInvisibility(WebElement element) {
        this.wait.until(ExpectedConditions.invisibilityOf(element));
        }
}
