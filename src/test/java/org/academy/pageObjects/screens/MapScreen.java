package org.academy.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;

/**
 * The Map screen class.
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*bottomSheetContainer\")")
    private AndroidElement mapContainer;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryListBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\")")
    private ArrayList<AndroidElement> categoryListContainer;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\").descriptionContains(\"Hotels\")")
    private AndroidElement hotelsBtn;

    public boolean mapContainerIsDisplayed() {
        return super.isElementAvailable(this.mapContainer);
    }

    /**
     * Gets map category list size.
     *
     * @return the map category list size
     */
    public int getMapCategoryListSize() {
        return this.categoryListContainer.size();
    }

    /**
     * Checks if Hotels button is displayed.
     *
     * @return the boolean
     */
    public boolean hotelsBtnIsDisplayed() {
        return super.isElementAvailable(this.hotelsBtn);
    }

    /**
     * Taps the categories list.
     */
    public void tapCategoryList() {
        super.tap(this.categoryListBtn);
    }
}