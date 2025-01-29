package com.ebcode.runner;

import com.ebcode.UtilWeb;
import com.ebcode.page.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

// cucumber-junit - dependency
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.ebcode.steps"}, // Donde está la definición de los steps
        features = "src/test/resources/features", // Ruta a los archivos .feature
        stepNotifications = true, plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", // HTML dentro de target/cucumber-reports
        "json:target/cucumber-reports/cucumber.json"  // JSON dentro de target/cucumber-reports
}, tags = "@freerangetesters-03")


public class Runner {
    private static final Logger log = UtilWeb.logger(Runner.class);

    @BeforeClass
    public static void setupDriver() {
        log.info("Setting up the driver");
    }

    @AfterClass
    public static void cleanDriver() {
        log.info("Closing the driver");
        BasePage.closeDriver();
    }
}
