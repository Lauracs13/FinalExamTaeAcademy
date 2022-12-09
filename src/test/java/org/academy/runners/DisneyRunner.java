package org.academy.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * The Disney runner.
 */
@CucumberOptions(
            features = "src/test/resources",
            glue = {"org.academy.tests.mobile"},
            tags = "@mobile")
    public class DisneyRunner extends AbstractTestNGCucumberTests {
    }


