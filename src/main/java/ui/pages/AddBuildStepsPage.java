package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.enums.BuildStepsOptions;
import ui.enums.TriggersOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static configs.EnvConfig.ENV_CONFIG;


@Slf4j
public class AddBuildStepsPage {
    public static AddBuildStepsPage getAddBuildStepsPage() {
        return new AddBuildStepsPage();
    }


    private AddBuildStepsPage() {
        // None
    }

    @Step("Select Build Steps option {0}")
    public AddBuildStepsPage selectBuildStepOption(@NotNull BuildStepsOptions buildStepsOptions) {
        log.info("Select Build Steps option {}.", buildStepsOptions.getText());
        Selenide.sleep(ENV_CONFIG.webElmRefreshDuration().multipliedBy(4).toMillis());
        executeJavaScript("document.querySelector('tr[data-test=\"runner-item " + buildStepsOptions.getText() + "\"] td').click();");
        Selenide.sleep(ENV_CONFIG.webElmRefreshDuration().multipliedBy(4).toMillis());

        return this;
    }

    @Step("Click Save button")
    public AddBuildStepsPage clickSaveButton() {
        log.info("Click Save Button");
        executeJavaScript("document.querySelector('#saveButtons .submitButton').click();");

        return this;
    }

    public SelenideElement getSuccessMsgElm() {
        return $(".successMessage#unprocessed_buildRunnerSettingsUpdated");
    }

}