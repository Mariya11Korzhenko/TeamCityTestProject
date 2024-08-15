package ui.enums;

import org.jetbrains.annotations.NotNull;

public enum BuildStepsOptions {
    ANT("Ant");

    private final String text;

    BuildStepsOptions(@NotNull String text) {
        this.text = text;
    }

    @NotNull
    public String getText() {
        return this.text;
    }
}
