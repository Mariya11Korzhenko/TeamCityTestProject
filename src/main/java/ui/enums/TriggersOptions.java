package ui.enums;

import org.jetbrains.annotations.NotNull;

public enum TriggersOptions {
    VCS_TRIGGER("VCS Trigger");

    private final String text;

    TriggersOptions(@NotNull String text) {
        this.text = text;
    }

    @NotNull
    public String getText() {
        return this.text;
    }
}
