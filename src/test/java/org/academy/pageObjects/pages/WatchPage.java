package org.academy.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Watch page class.
 */
public class WatchPage extends BasePage {
    @FindBy(css = "section.BucketsContainer > div:first-child ul.Carousel__Inner")
    private WebElement firstCarousel;
    @FindBy(css = "section.BucketsContainer > div:first-child ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCard;
    @FindBy(css = ".lightbox__wrapper")
    private WebElement cardModal;
    @FindBy(css = "svg.icon--color > use")
    private WebElement closeModalButton;

    /**
     * Constructor method.
     *
     * @param driver the driver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets the list of cards of the first carousel.
     *
     * @return the first carousel content
     */
    public List<WebElement> getFirstCarouselContent() {
        return this.firstCarousel.findElements(By.cssSelector("a"));
    }

    /**
     * Checks if the first carousel is displayed.
     *
     * @return the boolean
     */
    public boolean isFirstCarouselDisplayed() {
        super.waitForVisibility(this.firstCarousel);
        return this.firstCarousel.isDisplayed();
    }

    /**
     * Checks if a single card modal is displayed.
     *
     * @return the boolean
     */
    public boolean isCardModalDisplayed() {
        return this.cardModal.isDisplayed();
    }

    /**
     * Checks if all cards have title.
     *
     * @return the boolean
     */
    public boolean haveAllCardsTitle() {
        Stream<Boolean> withTitles = this.getFirstCarouselContent().stream().map(element -> {
            Boolean withTitle = element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals("");
            return withTitle;
        });

        return !withTitles.collect(Collectors.toList()).contains(true);
    }

    /**
     * Checks if all cards have description.
     *
     * @return the boolean
     */
    public boolean haveAllCardsDescription() {
        Stream<Boolean> withDescriptions = this.getFirstCarouselContent().stream().map(element -> {
            Boolean withDescription = element.findElement(By.cssSelector("div.WatchTile__Meta")).getText().equals("");
            return withDescription;
        });

        return !withDescriptions.collect(Collectors.toList()).contains(true);
    }

    /**
     * Click on second card.
     */
    public void clickOnSecondCard() {
        super.clickElement(this.secondCard);
    }

    /**
     * Checks if the close button is displayed.
     *
     * @return the boolean
     */
    public boolean isCloseModalButton() {
        super.waitForVisibility(this.closeModalButton);
        return this.closeModalButton.isDisplayed();
    }

    /**
     * Click on close button.
     */
    public void clickOnCloseModalButton() {
        super.clickElement(this.closeModalButton);
    }

    /**
     * Go back to homepage.
     *
     * @return the home page
     */
    public HomePage goBackToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
