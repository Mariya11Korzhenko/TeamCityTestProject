package ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static ui.pages.CreateBuildConfigurationPage.getCreateBuildConfigurationPage;


@Slf4j
public class NewVCSRootPage {

    private NewVCSRootPage() {
        // None
    }

    public static NewVCSRootPage getNewVCSRootPage() {
        return new NewVCSRootPage();
    }

    public SelenideElement getSuccessMsgElm() {
        return $(".successMessage#unprocessed_buildTypeCreated");
    }
}