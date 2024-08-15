package ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ui.pages.CreateProjectPage;
import ui.enums.UserProfileMenuOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static ui.pages.CreateProjectPage.getCreateProjectPage;


@Slf4j
public class TopPannel {

    private TopPannel() {
        // None
    }

    public static TopPannel getTopPannel() {
        return new TopPannel();
    }

    @Step("Open Header User Menu")
    public TopPannel openHeaderUserMenu() {
        log.info("Open Header User Menu");
        getHeaderUserMenuElm().click();

        return this;
    }

    @Step("Select {0} Option From Header User Menu")
    public TopPannel selectOptionFromHeaderUserMenu(UserProfileMenuOptions option) {
        log.info("Select {} Option From Header User Menu", option.getText());
        $x(".//div[@data-test='ring-popup']//div[@role='row']//a[normalize-space(text())='" + option.getText() + "']")
                .click();

        return this;
    }

    @Step("Click add New Project")
    public CreateProjectPage clickAddNewProject() {
        log.info("Click add New Project");
        $("[data-test-icon = 'add']").shouldBe(Condition.visible).click();

        return getCreateProjectPage();
    }

    public SelenideElement getHomeSignElm() {
        return $("a[title='Home']");
    }

    private SelenideElement getHeaderUserMenuElm() {
        return $("[data-test='ring-dropdown'] button");
    }
}