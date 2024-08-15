package core.enums;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import static configs.EnvConfig.ENV_CONFIG;

public enum User {
    USER(ENV_CONFIG.userLogin(), ENV_CONFIG.userPassword());

    private final String username;
    private final String password;

    User(@NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

    @NotNull
    public String getUsername() {
        return this.username;
    }

    @NotNull
    public String getPassword() {
        return this.password;
    }
}
