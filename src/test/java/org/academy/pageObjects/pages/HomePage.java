package org.academy.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Homepage class.
 */
public class HomePage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(id = "li.hover")
    private WebElement userMenu;
    @FindBy(css = "#global-header .tools .global-user-container>ul:first-child>li:last-child>a")
    private WebElement loginElement;
    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;
    @FindBy(id = "logo")
    private WebElement espnLogo;
    @FindBy(css = ".input-InputLoginValue")
    private WebElement usernameInput;
    @FindBy(css = ".input-InputPassword")
    private WebElement loginPassword;
    @FindBy(css = "button#BtnSubmit")
    private WebElement btnSubmit;
    @FindBy(css = "form.delete-profile-success button#BtnSubmit")
    private WebElement btnSubmit2;
    @FindBy(id = "Title")
    private WebElement signUpTitle;
    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(id = "InputFirstName")
    private WebElement inputFirstName;
    @FindBy(id = "InputLastName")
    private WebElement inputLastName;
    @FindBy(id = "InputEmail")
    private WebElement inputEmail;
    @FindBy(id = "password-new")
    private WebElement inputNewPassword;
    @FindBy(css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeUserMessage;
    @FindBy(css = "li.watch > a")
    private WebElement watchOption;
    @FindBy(id = "sideLogin-left-rail")
    private WebElement alternativeLogIn;
       @FindBy(id = "sideLogin-left-rail")
    private WebElement divOneIdWrapper;


    /**
     * Constructor method.
     *
     * @param driver the driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Hover the mouse on user icon.
     */
    public void hoverTheMouseOnUserIcon() {
        super.waitForVisibility(this.userIcon);
        super.hoverTheMouseOnElement(this.userIcon);
    }

    /**
     * Click on log in option.
     */
    public void clickOnLogInOption() {
        super.clickElement(this.loginElement);
    }

    /**
     * Click on log out option.
     */
    public void clickOnLogOutOption() {
        super.clickElement(this.loginElement);
    }

    /**
     * Wait for log out.
     */
    public void waitForLogOut() {
        super.waitForInvisibility(this.userMenu);
        super.waitForAttributeValue(this.alternativeLogIn, "style", "display: block;");
    }

    /**
     * Switch to login iframe.
     */
    public void switchToLoginIframe() {
        super.getDriver().switchTo().frame(this.loginIframe);
    }

    /**
     * Checks if ESPN logo is displayed.
     *
     * @return the boolean
     */
    public boolean isESPNLogoPresent() {
        super.waitForVisibility(this.espnLogo);
        return this.espnLogo.isDisplayed();
    }

    /**
     * Checks if login button is displayed.
     *
     * @return the boolean
     */
    public boolean isLogInButtonPresent() {
        super.waitForVisibility(this.btnSubmit);
        return this.btnSubmit.isDisplayed();
    }

    /**
     * Checks if First Name input is displayed.
     *
     * @return the boolean
     */
    public boolean isFirstNameInputPresent() {
        super.waitForVisibility(this.inputFirstName);
        return this.inputFirstName.isDisplayed();
    }

    /**
     * Checks if Last Name input is displayed.
     *
     * @return the boolean
     */
    public boolean isLastNameInputPresent() {
        super.waitForVisibility(this.inputLastName);
        return this.inputLastName.isDisplayed();
    }

    /**
     * Checks if Email input is displayed.
     *
     * @return the boolean
     */
    public boolean isEmailInputPresent() {
        super.waitForVisibility(this.inputEmail);
        return this.inputEmail.isDisplayed();
    }

    /**
     * Checks if Password input is displayed.
     *
     * @return the boolean
     */
    public boolean isPasswordInputPresent() {
        super.waitForVisibility(this.inputNewPassword);
        return this.inputNewPassword.isDisplayed();
    }

    /**
     * Click on sign up button.
     */
    public void clickOnSignUpButton() {
        super.clickElement(this.signUpButton);
    }

    /**
     * Click on username.
     */
    public void clickOnUsername() {
        super.clickElement(this.usernameInput);
    }

    /**
     * Click on password.
     */
    public void clickOnPassword() {
        super.clickElement(this.loginPassword);
    }

    /**
     * Click on submit button.
     */
    public void clickOnSubmitButton() {
        super.waitForVisibility(this.btnSubmit);
        super.hoverTheMouseOnElement(this.btnSubmit);
        super.clickElement(this.btnSubmit);
    }

    /**
     * Type the username.
     *
     * @param text the text
     */
    public void typeTheUsername(String text) {
        super.typeOnInput(this.usernameInput, text);
    }

    /**
     * Type the password.
     *
     * @param text the text
     */
    public void typeThePassword(String text) {
        super.typeOnInput(this.loginPassword, text);
    }

    /**
     * Type the first name.
     *
     * @param text the text
     */
    public void typeTheFirstName(String text) {
        super.typeOnInput(this.inputFirstName, text);
    }

    /**
     * Type the last name.
     *
     * @param text the text
     */
    public void typeTheLastName(String text) {
        super.typeOnInput(this.inputLastName, text);
    }

    /**
     * Type the email.
     *
     * @param text the text
     */
    public void typeTheEmail(String text) {
        super.typeOnInput(this.inputEmail, text);
    }

    /**
     * Type the new password.
     *
     * @param text the text
     */
    public void typeTheNewPassword(String text) {
        super.typeOnInput(this.inputNewPassword, text);
    }

    /**
     * Gets the text of the Welcome message in the user menu
     *
     * @return the string
     */
    public String navText() {
        super.waitForVisibility(this.welcomeUserMessage);
        return this.welcomeUserMessage.getText();
    }

    /**
     * Gets the text of the Sign Up modal
     *
     * @return the string
     */
    public String signUpTitleText() {
        super.waitForVisibility(this.signUpTitle);
        return this.signUpTitle.getText();
    }

    /**
     * Click on Watch option
     *
     * @return the watch page
     */
    public WatchPage switchToWatchPage() {
        super.clickElement(this.watchOption);
        return new WatchPage(getDriver());
    }

    /**
     * Close promo banner if exists.
     */
    public void closePromoBannerIfExists() {

        boolean isPromoBannerShown;
        WebElement promoBanner = null;
        try {
            promoBanner = super.getDriver().findElement(By.cssSelector(".promo-banner-container iframe"));
            isPromoBannerShown = true;
        } catch (NoSuchElementException e) {
            isPromoBannerShown = false;
        }
        if (isPromoBannerShown) {
            super.getDriver().switchTo().frame(promoBanner);
            WebElement closeBtn = super.getDriver().findElement(By.cssSelector(".PromoBanner__CloseBtn"));
            super.clickElement(closeBtn);
            super.getDriver().switchTo().defaultContent();
        }
    }

    public void scrollToBottom() {
        super.scrollToBottom();
    }

    /**
     * Wait for login success.
     */
    public void waitForLoginSuccess() {
        super.waitForAttributeValue(this.divOneIdWrapper, "style", "display: none;");
    }

}
