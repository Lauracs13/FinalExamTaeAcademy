package org.academy.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WatchPage extends BasePage{
    @FindBy(css = "section.BucketsContainer > div:first-child ul.Carousel__Inner")
    private WebElement firstCarousel;
    @FindBy(css = "section.BucketsContainer > div:first-child ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCard;
    @FindBy(css = "svg.icon--color > use")
    private WebElement closeModalButton;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getFirstCarouselContent() {
        return this.firstCarousel.findElements(By.cssSelector("a"));
    }
    public boolean haveAllCardsTitle() {
        Stream<Boolean> withTitles = this.getFirstCarouselContent().stream().map(element -> {
            Boolean withTitle = element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals("");
            return withTitle;
        });

        return !withTitles.collect(Collectors.toList()).contains(true);
    }
    public boolean haveAllCardsDescription() {
        Stream<Boolean> withDescriptions = this.getFirstCarouselContent().stream().map(element -> {
            Boolean withDescription = element.findElement(By.cssSelector("div.WatchTile__Meta")).getText().equals("");
            return withDescription;
        });

        return !withDescriptions.collect(Collectors.toList()).contains(true);
    }

    public void clickOnSecondCard() {
        super.clickElement(this.secondCard);
    }
    public boolean isCloseModalButton() {
        super.waitForVisibility(this.closeModalButton);
        return this.closeModalButton.isDisplayed();
    }
    public void clickOnCloseModalButton() {
        super.clickElement(this.closeModalButton);
    }

    public HomePage goBackToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
