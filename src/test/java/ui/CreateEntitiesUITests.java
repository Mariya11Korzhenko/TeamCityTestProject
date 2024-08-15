package ui;

import com.codeborne.selenide.Condition;
import core.enums.User;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import ui.enums.BuildStepsOptions;
import ui.enums.TriggersOptions;

import static api.data.TestApiProjects.TEST_PROJECT_BUILD_STEPS;
import static api.data.TestApiProjects.TEST_PROJECT_TRIGGER;
import static api.services.ProjectService.createProject;
import static ui.data.BuildConfigurationsUI.CREATE_BUILD_CONFIGURATION_UI_BUILD_STEPS_TEST;
import static ui.data.BuildConfigurationsUI.CREATE_BUILD_CONFIGURATION_UI_TRIGGER_TEST;
import static ui.data.ProjectsUI.TEST_CREATE_PROJECT_UI;
import static ui.elements.TopPannel.getTopPannel;
import static ui.enums.SuccessMessage.*;
import static ui.pages.EditBuildConfigurationPage.getEditBuildConfigurationPage;
import static ui.pages.EditBuildStepsPage.getEditBuildStepsPage;
import static ui.pages.EditProjectPage.getEditProjectPage;
import static ui.pages.LoginPage.getLoginPage;

@Epic("Create Entities Tests")
public class CreateEntitiesUITests extends UITestsSetup {

    @Test
    void verifyCreateProjectFunctionalityTest() {
        getLoginPage().loginAs(User.USER);
        getTopPannel().getHomeSignElm().shouldBe(Condition.visible);

        getTopPannel().clickAddNewProject()
                .createProject(TEST_CREATE_PROJECT_UI)
                .getSuccessMsgElm()
                .should(Condition.have(Condition.text(
                        String.format(SUCCESS_PROJECT_CREATION_MSG_TEST.getText(),
                                TEST_CREATE_PROJECT_UI.getProjectParent(), TEST_CREATE_PROJECT_UI.getName()))));
    }

    @Test
    void verifyCreateProjectBuildTriggerFunctionalityTest() {
        getLoginPage().loginAs(User.USER);
        getTopPannel().getHomeSignElm().shouldBe(Condition.visible);

        createProject(TEST_PROJECT_TRIGGER);

        getEditProjectPage().openAddTriggersPageForBuildWith(TEST_PROJECT_TRIGGER.getId());

        getEditProjectPage().clickCreateBuildConfiguration()
                .createBuildConfigurationPage(CREATE_BUILD_CONFIGURATION_UI_TRIGGER_TEST)
                .getSuccessMsgElm()
                .should(Condition.have(Condition.text(SUCCESS_BUILD_CREATION_MSG_TEST.getText())));

        getEditBuildConfigurationPage().openAddTriggersPageForBuildWith(CREATE_BUILD_CONFIGURATION_UI_TRIGGER_TEST.getBuildConfigurationId())
                .clickAddNewTrigger()
                .selectTriggersDropdownOption(TriggersOptions.VCS_TRIGGER)
                .clickSaveButton()
                .getSuccessMsgElm()
                .should(Condition.have(Condition.text(SUCCESS_TRIGGER_CREATION_MSG_TEST.getText())));
    }

    @Test
    void verifyCreateProjectBuildStepsFunctionalityTest() {
        getLoginPage().loginAs(User.USER);
        getTopPannel().getHomeSignElm().shouldBe(Condition.visible);

        createProject(TEST_PROJECT_BUILD_STEPS);

        getEditProjectPage().openAddTriggersPageForBuildWith(TEST_PROJECT_BUILD_STEPS.getId());

        getEditProjectPage().clickCreateBuildConfiguration()
                .createBuildConfigurationPage(CREATE_BUILD_CONFIGURATION_UI_BUILD_STEPS_TEST)
                .getSuccessMsgElm()
                .should(Condition.have(Condition.text(SUCCESS_BUILD_CREATION_MSG_TEST.getText())));

        getEditBuildStepsPage().openAddBuildStepsPageForBuildWith(CREATE_BUILD_CONFIGURATION_UI_BUILD_STEPS_TEST.getBuildConfigurationId())
                .clickAddBuildSteps()
                .selectBuildStepOption(BuildStepsOptions.ANT)
                .clickSaveButton()
                .getSuccessMsgElm()
                .should(Condition.have(Condition.text(SUCCESS_BUILD_STEPS_CREATION_MSG_TEST.getText())));
    }
}
