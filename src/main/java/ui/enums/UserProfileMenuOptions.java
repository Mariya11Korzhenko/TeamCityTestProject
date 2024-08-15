package ui.enums;

import org.jetbrains.annotations.NotNull;

public enum UserProfileMenuOptions {
    PROFILE("Profile"),
    FAVORITE_BUILDS("Favorite Builds"),
    INVESTIGATIONS("Investigations"),
    LOGOUT("Logout");

    private final String text;

    UserProfileMenuOptions(@NotNull String text) {
        this.text = text;
    }

    @NotNull
    public String getText() {
        return this.text;
    }
}
