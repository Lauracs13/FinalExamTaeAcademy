package org.academy.tests.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.academy.pageObjects.pages.HomePage;
import org.academy.utils.web.EspnWebDriver;

public class WebHooks {
    private static EspnWebDriver driver;
    private final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

    public static HomePage homepage;

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

    @After
    public void tearDown() {
        driver.getDriver().quit();
    }

    public static HomePage getHomePage() {
        return homepage;
    }
}