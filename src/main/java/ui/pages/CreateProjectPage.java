package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pojo.ProjectUI;

import static com.codeborne.selenide.Selenide.$;
import static ui.pages.EditProjectPage.getEditProjectPage;


@Slf4j
public class CreateProjectPage {

    private CreateProjectPage() {
        // None
    }

    public static CreateProjectPage getCreateProjectPage() {
        return new CreateProjectPage();
    }

    @Step("Create Project {0}.")
    public EditProjectPage createProject(ProjectUI projectUI) {
        selectParentProject(projectUI.getProjectParent());

        setValue("#name", projectUI.getName());
        $("#externalId").shouldNot(Condition.empty).clear();
        setValue("#externalId", projectUI.getProjectId());
        setValue("#description", projectUI.getDescription());

        $(".saveButtonsBlock .submitButton").click();

        return getEditProjectPage();
    }

    @Step("Select Parent Project {0}.")
    private CreateProjectPage selectParentProject(@NotNull String parentProject) {
        log.info("Selecting Parent Project '{}'", parentProject);

        SelenideElement parentIdSelect = $("#parentIdSelect");
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