package org.academy.utils.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * The Disney mobile driver.
 */
public class DisneyMobileDriver {
        private final AndroidDriver<AndroidElement> driver;

    /**
     * Instantiates a new Disney mobile driver.
     *
     * @param driver the driver
     */
    public DisneyMobileDriver(AndroidDriver<AndroidElement> driver) {
            this.driver = driver;
        }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public AndroidDriver<AndroidElement> getDriver() {
            return this.driver;
        }
    }

