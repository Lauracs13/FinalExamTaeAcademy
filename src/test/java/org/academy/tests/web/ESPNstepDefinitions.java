package org.academy.tests.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.academy.pageObjects.pages.HomePage;
import org.academy.utils.web.Driver;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static java.lang.String.format;

public class ESPNstepDefinitions {
    private Driver driver;
    private HomePage homepage;

    public Logger log = Logger.getLogger(ESPNstepDefinitions.class);

    private final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    private static final String FIRSTNAME = "pepa";
    private static final String LASTNAME = "perez";
    private final String PASSWORD = "pepaPerez1";
    private static String email = FIRSTNAME + "." + LASTNAME + (int) Math.floor(Math.random() * 10000) + "@email.com";

    @Given("user is on the ESPN landing page")
    public void userIsOnTheESPNLandingPage() {
        driver = new Driver();
        log.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        log.info(format("Navigating to %s", URL));
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        homepage = new HomePage(driver.getDriver());
    }
    @Given("user sees the dropdown user menu")
    public void userSeesTheDropdownUserMenu() {
        homepage.hoverTheMouseOnUserIcon();
    }
    @When("user clicks on the login option")
    public void userClicksOnTheLoginOption() {
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
    }
    @Then("login modal elements are displayed")
    public void loginModalElementsAreDisplayed() {
        log.info("Validate ESPN logo is displayed");
        Assert.assertTrue(homepage.isESPNLogoPresent(), "ESPN logo is not displayed");
        log.info("Validate Login button is displayed");
        Assert.assertTrue(homepage.isLogInButtonPresent(), "Login button is not displayed");
        log.info("Validate Sign up button is displayed");
        Assert.assertTrue(homepage.isLogInButtonPresent(), "Sign up button is not displayed");
    }

    @Given("user sees the login modal")
    public void userSeesTheLoginModal() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();

    }

    @When("user clicks on the sign up button")
    public void userClicksOnTheSignUpButton() {
        homepage.clickOnSignUpButton();
    }

    @Then("sign up elements are displayed")
    public void signUpElementsAreDisplayed() {
        log.info("Validate Sign Up title");
        Assert.assertEquals(homepage.signUpTitleText(), "Create Account", "Not expected Sign Up title");
        log.info("Validate First Name input is displayed");
        Assert.assertTrue(homepage.isFirstNameInputPresent(), "First Name input is not displayed");
        log.info("Validate Last Name input is displayed");
        Assert.assertTrue(homepage.isLastNameInputPresent(),"Last Name input is not displayed");
        log.info("Validate Email input is displayed");
        Assert.assertTrue(homepage.isEmailInputPresent(), "Email input is not displayed");
        log.info("Validate Password input is displayed");
        Assert.assertTrue(homepage.isPasswordInputPresent(), "Password input is not displayed");
        log.info("Validate Sign Up button is displayed");
        Assert.assertTrue(homepage.isPasswordInputPresent(), "Sign Up button is not displayed");
        log.info("Validate Close icon is displayed");
        Assert.assertTrue(homepage.isPasswordInputPresent(), "Close icon is not displayed");
    }

    @Given("user sees the sign up modal")
    public void userSeesTheSignUpModal() {
    }

    @When("user enters valid information in the form")
    public void userEntersValidInformationInTheForm() {
    }

    @And("user click on the submit sign up button")
    public void userClickOnTheSubmitSignUpButton() {
    }

    @Then("the sign up modal disappears")
    public void theSignUpModalDisappears() {
    }
}
