package ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;


import static com.codeborne.selenide.Selenide.closeWebDriver;

@Slf4j
public class UITestsSetup {
    private static final String ALLURE_LISTENER_NAME = "allure";

    @BeforeSuite
    public static void beforeUITestClassSetup() {
        // Note. Add listener that attach screenshots to allure report.
        SelenideLogger.addListener(ALLURE_LISTENER_NAME, new AllureSelenide()
                .savePageSource(true)
                .screenshots(true)
                .includeSelenideSteps(false));
    }


    @AfterMethod
    public void afterEachUITestPostProcessing() {
        log.debug("After each tests post processing.");
        closeWebDriver();
    }

    @AfterSuite
    public static void afterUITestClassTeardown() {
        SelenideLogger.removeListener(ALLURE_LISTENER_NAME);
    }
}
