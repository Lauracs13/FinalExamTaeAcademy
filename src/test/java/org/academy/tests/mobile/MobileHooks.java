package org.academy.tests.mobile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.academy.utils.mobile.ConfigCapabilities;
import org.academy.utils.mobile.DisneyMobileDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileHooks {

    private static DisneyMobileDriver mobileDriver;

    /**
     * SetUp before to run suite of test.
     *
     * @author Arley.Bolivar
     */
    @Before("@mobile")
    public void environmentSetUp(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@mobile")){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                ConfigCapabilities.deviceSetUp(capabilities);
                ConfigCapabilities.applicationSetUp(capabilities);
                try {
                    mobileDriver = new DisneyMobileDriver(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
                } catch (MalformedURLException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * Close the application after completing the test.
     *
     * @author Arley.Bolivar
     */
    @After
    public void mobileApplicationEnd() {
        mobileDriver.getDriver().quit();
    }

    public static AndroidDriver<AndroidElement> getDriver(){
        return mobileDriver.getDriver();
    }
}