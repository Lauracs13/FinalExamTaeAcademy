package org.academy.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * The Espn runner.
 */
@CucumberOptions(
        features = "src/test/resources",
        glue = {"org.academy.tests.web"},
        tags = "@web")
public class EspnRunner extends AbstractTestNGCucumberTests {
}
