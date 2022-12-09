package org.academy.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Object of the first screen that appears when we open the application.
 *
 * @author Arley.Bolivar
 */
public class TutorialScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Arley.Bolivar
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement getStartedBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement shareLocationBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*button1\")")
    private AndroidElement allowLocationBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_allow_foreground_only_button\")")
    private AndroidElement allowAccessWhileUsingAppBtn;

    /**
     * Initial steps to reach the dashboard screen
     *
     * @return the dashboard screen
     */
    public DashboardScreen loadDashBoardScreen() {
        tap(getStartedBtn);
        tap(shareLocationBtn);
        tap(allowLocationBtn);
        tap(allowAccessWhileUsingAppBtn);
        return new DashboardScreen(driver);
    }
}
