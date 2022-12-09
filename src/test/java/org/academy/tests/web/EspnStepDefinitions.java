package org.academy.tests.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.academy.pageObjects.pages.HomePage;
import org.academy.pageObjects.pages.WatchPage;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static org.academy.utils.mobile.StringUtils.*;

/**
 * The Espn step definitions.
 */
public class EspnStepDefinitions {

    /**
     * The Log.
     */
    public Logger log = Logger.getLogger(EspnStepDefinitions.class);
    /**
     * The Homepage.
     */
    public HomePage homepage = WebHooks.getHomePage();
    /**
     * The Watch page.
     */
    public WatchPage watchpage;

    /**
     * Closes the promo banner if exists.
     */
    @Given("user is on the ESPN landing page")
    public void userIsOnTheESPNLandingPage() {
        homepage.closePromoBannerIfExists();
    }

    /**
     * Allows to see the user menu.
     */
    @Given("user sees the dropdown user menu")
    public void userSeesTheDropdownUserMenu() {
        homepage.hoverTheMouseOnUserIcon();
    }

    /**
     * Clicks on the login option.
     */
    @When("user clicks on the login option")
    public void userClicksOnTheLoginOption() {
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
    }

    /**
     * Validates if Login modal elements are displayed.
     */
    @Then("login modal elements are displayed")
    public void loginModalElementsAreDisplayed() {
        log.info("Validate ESPN logo is displayed");
        Assert.assertTrue(homepage.isESPNLogoPresent(), "ESPN logo is not displayed");
        log.info("Validate Login button is displayed");
        Assert.assertTrue(homepage.isLogInButtonPresent(), "Login button is not displayed");
        log.info("Validate Sign up button is displayed");
        Assert.assertTrue(homepage.isLogInButtonPresent(), "Sign up button is not displayed");
    }

    /**
     * Displays the login modal is displayed.
     */
    @Given("user sees the login modal")
    public void userSeesTheLoginModal() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();

    }

    /**
     * Clicks on the Sign up button.
     */
    @When("user clicks on the sign up button")
    public void userClicksOnTheSignUpButton() {
        homepage.clickOnSignUpButton();
    }

    /**
     * Validates if Sign up elements are displayed.
     */
    @Then("sign up elements are displayed")
    public void signUpElementsAreDisplayed() {
        log.info("Validate Sign Up title");
        Assert.assertEquals(homepage.signUpTitleText(), "Create Account", "Not expected Sign Up title");
        log.info("Validate First Name input is displayed");
        Assert.assertTrue(homepage.isFirstNameInputPresent(), "First Name input is not displayed");
        log.info("Validate Last Name input is displayed");
        Assert.assertTrue(homepage.isLastNameInputPresent(), "Last Name input is not displayed");
        log.info("Validate Email input is displayed");
        Assert.assertTrue(homepage.isEmailInputPresent(), "Email input is not displayed");
        log.info("Validate Password input is displayed");
        Assert.assertTrue(homepage.isPasswordInputPresent(), "Password input is not displayed");
        log.info("Validate Sign Up button is displayed");
        Assert.assertTrue(homepage.isPasswordInputPresent(), "Sign Up button is not displayed");
        log.info("Validate Close icon is displayed");
        Assert.assertTrue(homepage.isPasswordInputPresent(), "Close icon is not displayed");
    }

    /**
     * Displays the Sign up modal.
     */
    @Given("user sees the sign up modal")
    public void userSeesTheSignUpModal() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        homepage.clickOnSignUpButton();
    }

    /**
     * Enters valid information in the form.
     */
    @When("user enters valid information in the form")
    public void userEntersValidInformationInTheForm() {
        homepage.typeTheFirstName(FIRSTNAME);
        homepage.typeTheLastName(LASTNAME);
        homepage.typeTheEmail(EMAIL);
        homepage.typeTheNewPassword(PASSWORD);
        homepage.scrollToBottom();
    }

    /**
     * Clicks on sign up button.
     */
    @And("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        homepage.clickOnSubmitButton();
        homepage.waitForLoginSuccess();
    }

    /**
     * Validates if the username is displayed.
     */
    @Then("user sees their name displayed")
    public void userSeesTheirNameDisplayed() {
        homepage.hoverTheMouseOnUserIcon();
        log.info("Validate the element 'Nav text' has the username");
        Assert.assertEquals(homepage.navText(), "Welcome" + FIRSTNAME + "!", "the element 'Nav text' do not have the username");
        homepage.closePromoBannerIfExists();
    }

    /**
     * Log in process
     */
    @Given("user is logged")
    public void userIsLogged() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        homepage.clickOnUsername();
        homepage.typeTheUsername(EMAIL);
        homepage.clickOnPassword();
        homepage.typeThePassword(PASSWORD);
        homepage.clickOnSubmitButton();
    }

    /**
     * Clicks on watch option.
     */
    @When("user clicks on Watch option")
    public void userClicksOnWatchOption() {
        watchpage = homepage.switchToWatchPage();
    }

    /**
     * Validates if at least one carousel is displayed.
     */
    @Then("at least one carousel is present")
    public void atLeastOneCarouselIsPresent() {
        log.info("Validate that at least one carousel is present");
        Assert.assertTrue(watchpage.isFirstCarouselDisplayed(), "the first carousel is not displayed");
    }

    /**
     * Validates if each card in the carousel has a title and a small description.
     */
    @And("each card in the carousel has a title and a small description")
    public void eachCardInTheCarouselHasATitleAndASmallDescription() {
        log.info("Validate all cards from first carousel have title");
        Assert.assertTrue(watchpage.haveAllCardsTitle(), "the title is not displayed in all the cards");
        log.info("Validate all cards from first carousel have description");
        Assert.assertTrue(watchpage.haveAllCardsDescription(), "the description is not displayed in all the cards");
    }

    /**
     * Goes to the watch page.
     */
    @And("User is on the Watch page")
    public void userIsOnTheWatchPage() {
        watchpage = homepage.switchToWatchPage();
    }

    /**
     * Clicks on the second card of the carousel.
     */
    @When("user clicks on the second card")
    public void userClicksOnTheSecondCard() {
        watchpage.clickOnSecondCard();
    }

    /**
     *Clicks on x button to close the modal.
     */
    @And("user clicks on x button")
    public void userClicksOnXButton() {
        log.info("Validate the 'x' button to close is displayed");
        Assert.assertTrue(watchpage.isCloseModalButton(), "the 'x' button to close is not displayed");
        watchpage.clickOnCloseModalButton();

    }

    /**
     * Verifies if the card modal disappears.
     */
    @Then("the card modal disappears")
    public void theCardModalDisappears() {
        log.info("Validate card modal is not displayed");
        Assert.assertFalse(watchpage.isCardModalDisplayed(), "card modal is displayed");
        homepage = watchpage.goBackToHomePage();
    }

    /**
     * Clicks on log out.
     */
    @And("user clicks on log out")
    public void userClicksOnLogOut() {
        homepage.hoverTheMouseOnUserIcon();
        log.info("User clicks on log out option");
        homepage.clickOnLogOutOption();
        homepage.waitForLogOut();
    }

    /**
     * Verifies if the username disappears.
     */
    @Then("the username disappears")
    public void theUsernameDisappears() {
        homepage.hoverTheMouseOnUserIcon();
        log.info("Validate the element 'Nav text' do not have the username");
        Assert.assertEquals(homepage.navText(), "Welcome!", "the element 'Nav text' still has the username");
    }
}