package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pojo.BuildConfigurationUI;

import static com.codeborne.selenide.Selenide.$;
import static configs.EnvConfig.ENV_CONFIG;
import static ui.pages.NewVCSRootPage.getNewVCSRootPage;


@Slf4j
public class CreateBuildConfigurationPage {

    private CreateBuildConfigurationPage() {
        // None
    }

    public static CreateBuildConfigurationPage getCreateBuildConfigurationPage() {
        return new CreateBuildConfigurationPage();
    }

    @Step("Create Build Configuration {0}.")
    public NewVCSRootPage createBuildConfigurationPage(BuildConfigurationUI buildConfigurationUI) {
        selectParentProject(buildConfigurationUI.getProjectParentName());

        setValue("#buildTypeName", buildConfigurationUI.getName());
        Selenide.sleep(ENV_CONFIG.webElmRefreshDuration().multipliedBy(2).toMillis());
        $("#buildTypeExternalId").shouldNot(Condition.empty).clear();
        Selenide.sleep(ENV_CONFIG.webElmRefreshDuration().multipliedBy(2).toMillis());
        setValue("#buildTypeExternalId", buildConfigurationUI.getBuildConfigurationId());
        setValue("#description", buildConfigurationUI.getDescription());

        $(".saveButtonsBlock .submitButton").click();

        return getNewVCSRootPage();
    }

    @Step("Select Parent Project {0}.")
    private CreateBuildConfigurationPage selectParentProject(@NotNull String parentProject) {
        log.info("Selecting Parent Project '{}'", parentProject);

        SelenideElement parentIdSelect = $("#parentProjectIdSelect")
                .shouldBe(Condition.visible).shouldNot(Condition.be(Condition.empty));
        if (!parentIdSelect.has(Condition.text(parentProject))) {
            parentIdSelect.click();
            setValue(".ring-input-input", parentProject);
            $("[data-project-id='" + parentProject + "']").click();
        } else {
            log.info("'{}' is already selected, skipping selection", parentProject);
        }

        return this;
    }

    private void setValue(String selector, String value) {
        $(selector).val(value);
    }
}