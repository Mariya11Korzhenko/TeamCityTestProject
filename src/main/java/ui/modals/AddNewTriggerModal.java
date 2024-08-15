package ui.modals;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.enums.TriggersOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static configs.EnvConfig.ENV_CONFIG;


@Slf4j
public class AddNewTriggerModal {
    public static AddNewTriggerModal getAddNewTriggerModal() {
        return new AddNewTriggerModal();
    }


    private AddNewTriggerModal() {
        // None
    }

    @Step("Open triggers dropdown and select trigger {0}")
    public AddNewTriggerModal selectTriggersDropdownOption(@NotNull TriggersOptions trigger) {
        log.info("Open triggers dropdown and select trigger {}.", trigger.getText());
        executeJavaScript("document.getElementById('-ufd-teamcity-ui-triggerNameSelector').click();");
        executeJavaScript("document.querySelector('li[data-title=\"" + trigger.getText() + "\"]').click();");

        return this;
    }

    @Step("Click Save button")
    public AddNewTriggerModal clickSaveButton() {
        log.info("Click Save Button");
        $("#editTriggerSubmit").click();

        return this;
    }

    public SelenideElement getSuccessMsgElm() {
        return $(".successMessage#unprocessed_buildTriggersUpdated");
    }

}