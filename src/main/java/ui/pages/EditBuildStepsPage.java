package ui.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.modals.AddNewTriggerModal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static configs.EnvConfig.ENV_CONFIG;
import static ui.modals.AddNewTriggerModal.getAddNewTriggerModal;
import static ui.pages.AddBuildStepsPage.getAddBuildStepsPage;


@Slf4j
public class EditBuildStepsPage {
    private static final String BASE_URL = Configuration.baseUrl = ENV_CONFIG.baseUrl();

    public static EditBuildStepsPage getEditBuildStepsPage() {
        return new EditBuildStepsPage();
    }


    private EditBuildStepsPage() {
        // None
    }

    @Step("Open add build steps page for build config with id {0}.")
    public EditBuildStepsPage openAddBuildStepsPageForBuildWith(@NotNull String buildId) {
        log.info("Open add build steps page for build config with id {}.", buildId);
        Selenide.open(BASE_URL + String.format("/admin/editBuildRunners.html?id=buildType:%s", buildId));

        return this;
    }

    @Step("Click Add Build Steps.")
    public AddBuildStepsPage clickAddBuildSteps() {
        log.info("Click Add Build Steps");
        executeJavaScript("document.querySelector('.btn .addNew').parentElement.click();");

        return getAddBuildStepsPage();
    }
}