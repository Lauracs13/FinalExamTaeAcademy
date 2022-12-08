package org.academy.tests.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.academy.pageObjects.screens.DashboardScreen;
import org.academy.pageObjects.screens.MapScreen;
import org.academy.pageObjects.screens.TutorialScreen;
import org.academy.utils.mobile.ConfigCapabilities;
import org.academy.utils.mobile.DisneyMobileDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class DisneyStepDefinitions {

    private TutorialScreen tutorialScreen;
    /**
     * The Dashboard screen.
     */
    private DashboardScreen dashboardScreen;
    private MapScreen mapScreen;
    /**
     * The Driver.
     */
    private DisneyMobileDriver mobileDriver;
    /**
     * The Log.
     */
    public Logger log = Logger.getLogger(DisneyStepDefinitions.class);


    /**
     * SetUp before to run suite of test.
     *
     * @author Arley.Bolivar
     */
    @Before("@mobile")
    public void environmentSetUp(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@mobile")){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            mobileDriver = new DisneyMobileDriver(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
            }
        });
    }

    /**
     * Close the application after completing the test.
     *
     * @author Arley.Bolivar
     */
    @After
    public void mobileApplicationEnd() {
        mobileDriver.getDriver().quit();
    }

    @Given("user is on the dashboard")
    public void userIsOnTheDashboard() {
        log.info("Start Navigation to the Dashboard");
        tutorialScreen = new TutorialScreen(mobileDriver.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashboardScreen = tutorialScreen.shareLocationPermissions();

    }

    @When("user taps on the Map button")
    public void userTapsOnTheMapButton() {
        log.info("Start Navigation to Map Screen");
        mapScreen = dashboardScreen.goToMapScreen();
        log.info("Validate Map View");
        Assert.assertTrue(mapScreen.mapContainerIsDisplayed(), "Map View not displayed");
    }

    @And("user taps on the Category list")
    public void userTapsOnTheCategoryList() {
        log.info("Tapping Category List Button");
        mapScreen.tapCategoryList();
    }

    @Then("Hotels option is available in the list")
    public void hotelsOptionIsAvailableInTheList() {
        log.info("Validate Categories Listed");
        Assert.assertEquals(mapScreen.getMapCategoryListSize(), 13, "Incomplete Categories displayed");
        log.info("Validate Hotels Button");
        Assert.assertTrue(mapScreen.hotelsBtnIsDisplayed(), "Hotels Button not displayed");
    }

    @When("user taps on Menu button")
    public void userTapsOnMenuButton() {
    }

    @And("user taps on Privacy & Legal option")
    public void userTapsOnPrivacyLegalOption() {
    }

    @Then("a list of options is displayed")
    public void aListOfOptionsIsDisplayed() {
    }
}
