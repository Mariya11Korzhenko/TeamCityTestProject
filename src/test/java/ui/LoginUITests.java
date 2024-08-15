package ui;

import com.codeborne.selenide.Condition;
import core.enums.User;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import ui.enums.UserProfileMenuOptions;

import static configs.EnvConfig.ENV_CONFIG;
import static ui.elements.TopPannel.getTopPannel;
import static ui.pages.LoginPage.getLoginPage;

@Epic("Login Tests")
public class LoginUITests extends UITestsSetup {

    @Test
    void verifyLoginLogoutFunctionalityTest() {
        getLoginPage().loginAs(User.USER);
        getTopPannel().getHomeSignElm().shouldBe(Condition.visible, ENV_CONFIG.pageLoadDuration());

        getTopPannel().openHeaderUserMenu().selectOptionFromHeaderUserMenu(UserProfileMenuOptions.LOGOUT);
        getTopPannel().getHomeSignElm().shouldNot(Condition.visible);
    }
}
