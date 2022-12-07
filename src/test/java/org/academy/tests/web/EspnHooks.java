package org.academy.tests.web;

import io.cucumber.java.*;
import org.academy.pageObjects.pages.HomePage;
import org.academy.utils.web.WebDriver;

public class EspnHooks {

    private static WebDriver driver;
    private HomePage homepage;

    public static WebDriver getDriver() {
       return driver.getDriver();
    }

    private final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

    @Before
    public void setUpBefore(){
        driver = new WebDriver();
        driver.getDriver().manage().deleteAllCookies();
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();

    }

    @After
    public void tearDown() {
        driver.getDriver().quit();
    }


}
