package api.services;

import core.enums.User;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

import static configs.EnvConfig.ENV_CONFIG;
import static core.enums.User.USER;
import static io.restassured.RestAssured.given;

@Slf4j
public class AuthService {

    private static final String AUTH_URL = ENV_CONFIG.baseUrl();
    private static final User DEFAULT_USER_FOR_AUTH = USER;


    private AuthService() {
        // None
    }

    protected static RequestSpecification requestNewAccessToken(@NotNull User user) {
        log.info("API: Request access token for '{}' user.", user.getUsername());

        String auth =  user.getUsername() + ":" + user.getPassword();
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        return given()
                .baseUri(AUTH_URL)
                .header("Accept", "application/json")
                .header("Authorization", "Basic " + encodedAuth);
    }

    protected static RequestSpecification requestNewAccessToken() {
        log.info("API: Request access token for '{}' user.", DEFAULT_USER_FOR_AUTH.getUsername());

        String auth =  DEFAULT_USER_FOR_AUTH.getUsername() + ":" + DEFAULT_USER_FOR_AUTH.getPassword();
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        return given()
                .baseUri(AUTH_URL)
                .header("Accept", "application/json")
                .header("Authorization", "Basic " + encodedAuth);
    }
}
