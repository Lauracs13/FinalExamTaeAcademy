package org.academy.tests.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.academy.pageObjects.pages.HomePage;
import org.academy.utils.web.EspnWebDriver;

import static org.academy.utils.mobile.StringUtils.*;

/**
 * The Web hooks.
 */
public class WebHooks {
    private static EspnWebDriver driver;
    /**
     * The homepage instance.
     */
    public static HomePage homepage;

    /**
     * Set up before each scenario
     *
     * @param scenario the scenario
     */
    @Before
    public void setUpBefore(Scenario scenario){
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@web")) {
                driver = new EspnWebDriver();
                driver.getDriver().manage().deleteAllCookies();
                driver.getDriver().get(URL);
                driver.getDriver().manage().window().maximize();
                homepage = new HomePage(driver.getDriver());
            }
        });
    }

    /**
     * Closes the webpage after each scenario.
     */
    @After
    public void tearDown() {
        driver.getDriver().quit();
    }

    /**
     * Gets home page.
     *
     * @return the home page
     */
    public static HomePage getHomePage() {
        return homepage;
    }
}