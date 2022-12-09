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
 * The Privacy & Legal screen.
 */
public class PrivacyAndLegalScreen extends BaseScreen {
    /**
     * Instantiates a new Privacy & Legal screen.
     *
     * @param driver the driver
     */
    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "txt_element")
    private ArrayList<AndroidElement> privacyAndLegalElements;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*panel_container\")")
    private AndroidElement privacyAndLegalContainer;

    /**
     * Checks if Privacy & Legal container is displayed.
     *
     * @return the boolean
     */
    public boolean privacyAndLegalContainerIsDisplayed() {
        return super.isElementAvailable(this.privacyAndLegalContainer);
    }

    /**
     * Checks if Privacy & Legal elements is displayed.
     *
     * @return the boolean
     */
    public boolean privacyAndLegalElementsAreDisplayed() {
        boolean result = true;
        ArrayList<String> expectedOptions = new ArrayList<>(Arrays.asList("Privacy Policy", "Terms of Use", "Supplemental Terms and Conditions", "Legal Notices", "Property Rules", "Electronic Communications Disclosure"));
        List<String> privacyAndLegalNameElements = this.privacyAndLegalElements.stream().map(element -> element.getText()).collect(Collectors.toList());
        HashSet<String> privacyAndLegalSet = new HashSet<>(privacyAndLegalNameElements);
        for (int i = 0; i < expectedOptions.size(); i++) {
            if (!privacyAndLegalSet.contains(expectedOptions.get(i))) {
                result = false;
                break;
            }
        }
        return result;
    }
}