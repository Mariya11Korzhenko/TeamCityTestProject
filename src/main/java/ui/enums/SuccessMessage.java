package ui.enums;

import org.jetbrains.annotations.NotNull;

public enum SuccessMessage {
    SUCCESS_PROJECT_CREATION_MSG_TEST("Project \"%s / %s\" has been successfully created. You can now create a build configuration."),
    SUCCESS_BUILD_CREATION_MSG_TEST("Build configuration successfully created. You can now configure VCS roots."),
    SUCCESS_TRIGGER_CREATION_MSG_TEST("Triggers updated"),
    SUCCESS_BUILD_STEPS_CREATION_MSG_TEST("Build step settings updated.");

    private final String text;

    SuccessMessage(@NotNull String text) {
        this.text = text;
    }

    @NotNull
    public String getText() {
        return this.text;
    }
}
