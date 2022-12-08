package org.academy.utils.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DisneyMobileDriver {
        private final AndroidDriver<AndroidElement> driver;

        public DisneyMobileDriver(AndroidDriver<AndroidElement> driver) {
            this.driver = driver;
        }

        public AndroidDriver<AndroidElement> getDriver() {
            return this.driver;
        }
    }

