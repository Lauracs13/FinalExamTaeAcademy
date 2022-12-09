package org.academy.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Menu screen class.
 */
public class MenuScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*content\")")
    private ArrayList<AndroidElement> bottomMenuOptions;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*content\").textContains(\"Privacy\")")
    private AndroidElement privacyAndLegalBtn;

    public void scrollToBottom() {
        super.scrollToBottom();
    }

    /**
     * Taps the Privacy & Legal button to go to Privacy & Legal screen.
     *
     * @return the Privacy & Legal screen
     */
    public PrivacyAndLegalScreen tapPrivacyAndLegalBtn() {
        super.tap(this.privacyAndLegalBtn);
        return new PrivacyAndLegalScreen(super.getDriver());
    }

    /**
     * Checks if bottom Menu options are displayed.
     *
     * @return the boolean
     */
    public boolean bottomMenuOptionsAreDisplayed() {
        boolean result = true;
        ArrayList<String> expectedOptions = new ArrayList<>(Arrays.asList("My Profile", "Property Rules", "Link to Account", "Help", "Privacy & Legal"));
        List<String> bottomMenuNames = this.bottomMenuOptions.stream().map(element -> element.getText()).collect(Collectors.toList());
        HashSet<String> bottomMenuSet = new HashSet<>(bottomMenuNames);
        for (int i = 0; i < expectedOptions.size(); i++) {
            if (!bottomMenuSet.contains(expectedOptions.get(i))) {
                result = false;
                break;
            }
        }
        return result;
    }
}
