package ui.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.enums.User;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.$;
import static configs.EnvConfig.ENV_CONFIG;


@Slf4j
public class LoginPage {
    private static final String BASE_URL = Configuration.baseUrl = ENV_CONFIG.baseUrl();

    private LoginPage() {
        // None
    }

    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    @Step("Login as: {0}.")
    public void loginAs(User user) {
        loginAs(user.getUsername(), user.getPassword());
    }

    private void loginAs(@NotNull String username, @NotNull String password) {
        log.info("Login as: {}", username);
        open();

        $("#loginPasswordSwitch").click();
        $("#username").val(username);
        $("#password").val(password);
        $("input.btn.loginButton").click();
    }

    @Step("Open login page.")
    private LoginPage open() {
        log.info("Open login page.");
        Selenide.open(BASE_URL);

        return this;
    }
}