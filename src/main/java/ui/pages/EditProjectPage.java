package ui.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static configs.EnvConfig.ENV_CONFIG;
import static ui.pages.CreateBuildConfigurationPage.getCreateBuildConfigurationPage;
import static ui.pages.CreateProjectPage.getCreateProjectPage;


@Slf4j
public class EditProjectPage {
    private static final String BASE_URL = Configuration.baseUrl = ENV_CONFIG.baseUrl();

    private EditProjectPage() {
        // None
    }

    @Step("Open edit project page with project id {0}.")
    public EditProjectPage openAddTriggersPageForBuildWith(@NotNull String projectId) {
        log.info("Open edit project page with project id {}.", projectId);
        Selenide.open(BASE_URL + String.format("/admin/editProject.html?projectId=%s", projectId));

        return this;
    }

    public static EditProjectPage getEditProjectPage() {
        return new EditProjectPage();
    }

    public SelenideElement getSuccessMsgElm() {
        return $(".editProjectPage .successMessage");
    }

    public CreateBuildConfigurationPage clickCreateBuildConfiguration() {
        $("a.btn span.addNew").click();
        return getCreateBuildConfigurationPage();
    }
}