package org.academy.tests.mobile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.academy.pageObjects.screens.*;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class DisneyStepDefinitions {

    private TutorialScreen tutorialScreen;
    private DashboardScreen dashboardScreen;
    private MapScreen mapScreen;
    private MenuScreen menuScreen;
    private PrivacyAndLegalScreen privacyAndLegal;
    public Logger log = Logger.getLogger(DisneyStepDefinitions.class);

    @Given("user is on the dashboard")
    public void userIsOnTheDashboard() {
        log.info("Start Navigation to the Dashboard");
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        dashboardScreen = tutorialScreen.loadDashBoardScreen();
        dashboardScreen.dismissLoadingDashboardOptions();

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

    @When("user taps on the Menu button")
    public void userTapsOnTheMenuButton() {
        log.info("Validate Menu button");
        Assert.assertTrue(dashboardScreen.menuBtnIsDisplayed(), "Menu button not displayed");

        log.info("Tapping the Menu button");
        menuScreen = dashboardScreen.goToMenuScreen();
    }

    @And("user taps on Privacy & legal option")
    public void userTapsOnPrivacyLegalOption() {
        log.info("Scrolling to bottom");
        menuScreen.scrollToBottom();

        log.info("Validate Bottom Menu options");
        Assert.assertTrue(menuScreen.bottomMenuOptionsAreDisplayed(), "Bottom Menu options not displayed");

        log.info("Tapping the Privacy & Legal button");
        privacyAndLegal = menuScreen.tapPrivacyAndLegalBtn();
    }

    @Then("a list of options is displayed")
    public void aListOfOptionsIsDisplayed() {
        log.info("Validate Privacy & Legal screen");
        Assert.assertTrue(privacyAndLegal.privacyAndLegalContainerIsDisplayed(), "Privacy & Legal screen not displayed");

        log.info("Validate Privacy & Legal list of 6 options");
        Assert.assertTrue(privacyAndLegal.privacyAndLegalElementsAreDisplayed(), "Privacy & Legal list of 6 options not displayed");
    }

    @When("user taps on Add Plans Button")
    public void userTapsOnAddPlansButton() {
        log.info("Tapping Add Plans button");
        dashboardScreen.tapAddPlansBtn();
    }

    @Then("the Reserve Dining Option is in the list")
    public void theReserveDiningOptionIsInTheList() {
        log.info("Validate Plans Options list");
        Assert.assertEquals(dashboardScreen.getAddPlansOptionsSize(), 7, "Incomplete Plans Options list displayed");

        log.info("Validate Check Dining Availability button");
        Assert.assertTrue(dashboardScreen.checkDiningAvailabilityBtnIsDisplayed(), "Check Dining Availability not displayed");
    }
}