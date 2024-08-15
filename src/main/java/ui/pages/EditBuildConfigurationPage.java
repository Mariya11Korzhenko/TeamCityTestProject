package ui.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.modals.AddNewTriggerModal;

import static com.codeborne.selenide.Selenide.*;
import static configs.EnvConfig.ENV_CONFIG;
import static ui.modals.AddNewTriggerModal.getAddNewTriggerModal;
import static ui.pages.CreateBuildConfigurationPage.getCreateBuildConfigurationPage;


@Slf4j
public class EditBuildConfigurationPage {
    private static final String BASE_URL = Configuration.baseUrl = ENV_CONFIG.baseUrl();

    public static EditBuildConfigurationPage getEditBuildConfigurationPage() {
        return new EditBuildConfigurationPage();
    }


    private EditBuildConfigurationPage() {
        // None
    }

    @Step("Open add triggers page for build config with id {0}.")
    public EditBuildConfigurationPage openAddTriggersPageForBuildWith(@NotNull String buildId) {
        log.info("Open add triggers page for build config with id {}.", buildId);
        Selenide.open(BASE_URL + String.format("/admin/editTriggers.html?id=buildType:%s", buildId));

        return this;
    }

    @Step("Click Add new trigger.")
    public AddNewTriggerModal clickAddNewTrigger() {
        log.info("Click Add new Trigger");
        executeJavaScript("document.querySelector('.btn .addNew').parentElement.click();");

        return getAddNewTriggerModal();
    }
}