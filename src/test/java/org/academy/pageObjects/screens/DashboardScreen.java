package org.academy.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;

/**
 * DashBoard screen.
 */
public class DashboardScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashboardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*button2\")")
    private AndroidElement dismissPreferenceUpdateBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*dismiss-icon\")")
    private AndroidElement dismissWelcomeIcon;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tabContainer\").childSelector(new UiSelector().resourceIdMatches(\".*tab_icon\").instance(1))")
    private AndroidElement mapBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_animated_icon\")")
    private AndroidElement addPlansBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*bottomTabBar\").childSelector(new UiSelector().className(\"android.widget.LinearLayout\").instance(5))")
    private AndroidElement menuBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionSheetItemText\").textContains(\"Dining\")")
    private AndroidElement checkDiningAvailabilityBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionSheetItemText\")")
    private ArrayList<AndroidElement> addPlansOptions;

    /**
     * Gets dismiss preference update button.
     *
     * @return the dismiss preference update button
     */
    public AndroidElement getDismissPreferenceUpdateBtn() {
        return this.dismissPreferenceUpdateBtn;
    }

    /**
     * Gets dismiss welcome icon.
     *
     * @return the dismiss welcome icon
     */
    public AndroidElement getDismissWelcomeIcon() {
        return this.dismissWelcomeIcon;
    }

    /**
     * Go to Map screen.
     *
     * @return the Map screen
     */
    public MapScreen goToMapScreen() {
        super.tap(this.mapBtn);
        return new MapScreen(super.getDriver());
    }

    /**
     * Go to Menu screen.
     *
     * @return the Menu screen
     */
    public MenuScreen goToMenuScreen() {
        super.tap(this.menuBtn, 30);
        return new MenuScreen(super.getDriver());
    }

    /**
     * Checks if Menu button is displayed.
     *
     * @return the boolean
     */
    public boolean menuBtnIsDisplayed() {
        return super.isElementAvailable(this.menuBtn);
    }

    /**
     * Tap Add Plans button.
     */
    public void tapAddPlansBtn() {
        super.tap(this.addPlansBtn);
    }

    /**
     * Gets Add Plans options size.
     *
     * @return the add plans options size
     */
    public int getAddPlansOptionsSize() {
        return this.addPlansOptions.size();
    }

    /**
     * Checks if dining availability button is displayed.
     *
     * @return the boolean
     */
    public boolean checkDiningAvailabilityBtnIsDisplayed() {
        return super.isElementAvailable(this.checkDiningAvailabilityBtn);
    }

    /**
     * Dismiss loading dashboard options if appeared.
     */
    public void dismissLoadingDashboardOptions() {
        if (this.isElementAvailable(getDismissWelcomeIcon(), 25)) {
            tap(getDismissWelcomeIcon());
        }
        if (this.isElementAvailable(getDismissPreferenceUpdateBtn(), 25)) {
            tap(getDismissPreferenceUpdateBtn());
        }
    }
}
