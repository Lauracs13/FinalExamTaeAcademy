package org.academy.tests.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.academy.pageObjects.pages.HomePage;
import org.academy.pageObjects.pages.WatchPage;
import org.academy.utils.web.EspnWebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static java.lang.String.format;

public class EspnStepDefinitions {

    public Logger log = Logger.getLogger(EspnStepDefinitions.class);
    private static final String FIRSTNAME = "prueba";
    private static final String LASTNAME = "perez";
    //private final String PASSWORD = "pepaPerez1@";
    private final String PASSWORD = "nuevacontrasena@";
    //private static String email = FIRSTNAME + "." + LASTNAME + (int) Math.floor(Math.random() * 10000) + "@email.com";
    private static String email = "prueba.perez9256@email.com";

    private EspnWebDriver driver;
    public HomePage homepage;
    public WatchPage watchpage;

    private final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

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
    @Given("user is on the ESPN landing page")
    public void userIsOnTheESPNLandingPage() {

    homepage.closePromoBannerIfExists();
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

    @Given("user sees the sign up modal")
    public void userSeesTheSignUpModal() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        homepage.clickOnSignUpButton();
    }

    @When("user enters valid information in the form")
    public void userEntersValidInformationInTheForm() {
        homepage.typeTheFirstName(FIRSTNAME);
        homepage.typeTheLastName(LASTNAME);
        homepage.typeTheEmail(email);
        homepage.typeTheNewPassword(PASSWORD);
        homepage.scrollToBottom();
    }

    @And("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        homepage.clickOnSubmitButton();
        homepage.waitForLoginSuccess();
    }

    @Then("user sees their name displayed")
    public void userSeesTheirNameDisplayed() {
        homepage.hoverTheMouseOnUserIcon();
        log.info("Validate the element 'Nav text' has the username");
        Assert.assertEquals(homepage.navText(), "Welcome" + FIRSTNAME + "!", "the element 'Nav text' do not have the username");
        homepage.closePromoBannerIfExists();
    }

    @Given("user is logged")
    public void userIsLogged() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        homepage.clickOnUsername();
        homepage.typeTheUsername(email);
        homepage.clickOnPassword();
        homepage.typeThePassword(this.PASSWORD);
        homepage.clickOnSubmitButton();
    }

    @When("user clicks on Watch option")
    public void userClicksOnWatchOption() {
        watchpage = homepage.switchToWatchPage();
    }

    @Then("at least one carousel is present")
    public void atLeastOneCarouselIsPresent() {
        log.info("Validate that at least one carousel is present");
        Assert.assertTrue(watchpage.isFirstCarouselDisplayed(), "the first carousel is not displayed");
    }

    @And("each card in the carousel has a title and a small description")
    public void eachCardInTheCarouselHasATitleAndASmallDescription() {
        log.info("Validate all cards from first carousel have title");
        Assert.assertTrue(watchpage.haveAllCardsTitle(), "the title is not displayed in all the cards");
        log.info("Validate all cards from first carousel have description");
        Assert.assertTrue(watchpage.haveAllCardsDescription(), "the description is not displayed in all the cards");
    }

    @And("User is on the Watch page")
    public void userIsOnTheWatchPage() {
        watchpage = homepage.switchToWatchPage();
    }

    @When("user clicks on the second card")
    public void userClicksOnTheSecondCard() {
        watchpage.clickOnSecondCard();
    }

    @And("user clicks on x button")
    public void userClicksOnXButton() {
        log.info("Validate the 'x' button to close is displayed");
        Assert.assertTrue(watchpage.isCloseModalButton(), "the 'x' button to close is not displayed");
        watchpage.clickOnCloseModalButton();

    }
    @Then("the card modal disappears")
    public void theCardModalDisappears() {
        log.info("Validate card modal is not displayed");
        Assert.assertFalse(watchpage.isCardModalDisplayed(), "card modal is displayed");
        homepage = watchpage.goBackToHomePage();
    }
    @And("user clicks on log out")
    public void userClicksOnLogOut() {
        homepage.hoverTheMouseOnUserIcon();
        log.info("User clicks on log out option");
        homepage.clickOnLogOutOption();
        homepage.waitForLogOut();
    }
    @Then("the username disappears")
    public void theUsernameDisappears() {
        homepage.hoverTheMouseOnUserIcon();
        log.info("Validate the element 'Nav text' do not have the username");
        Assert.assertEquals(homepage.navText(), "Welcome!", "the element 'Nav text' still has the username");
    }


}
