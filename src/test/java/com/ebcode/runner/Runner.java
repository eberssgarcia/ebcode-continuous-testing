package com.ebcode.runner;

import com.ebcode.page.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

// cucumber-junit - dependency
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.ebcode.steps"}, // Donde esta la definition para los Step de los features
        features = "src/test/resources/features",
        stepNotifications = true,
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@freerangetesters-03")

public class Runner {
    @AfterClass
    public static void cleanDriver() {
        BasePage.closeDriver();
    }
}
