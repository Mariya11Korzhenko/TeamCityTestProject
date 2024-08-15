package api.services;

import api.pojo.project.ProjectCreateResponse;
import api.pojo.project.ProjectPayload;
import api.pojo.project.ProjectResponse;
import api.pojo.user.UserCreateResponse;
import api.pojo.user.UserPayload;
import api.pojo.user.UserResponse;
import core.enums.User;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static api.services.AuthService.requestNewAccessToken;
import static java.net.HttpURLConnection.*;

@Slf4j
public class UserService {
    private static final String USER_PATH = "/app/rest/users";
    private static final String UPDATE_DELETE_USER_PATH = "/app/rest/users/id:%s";

    public static UserResponse getUsers() {
        log.info("API: Get users.");

        return requestNewAccessToken()
                .basePath(USER_PATH)
                .get()
                .then()
                .statusCode(HTTP_OK)
                .extract()
                .as(UserResponse.class);
    }

    @Step("API: Create {0} user")
    public static UserCreateResponse createUser(@NotNull UserPayload userPayload) {
        log.info("API: Create '{}' user.", userPayload);

        return requestNewAccessToken()
                .contentType(ContentType.JSON)
                .basePath(USER_PATH)
                .body(userPayload)
                .post()
                .then()
                .statusCode(HTTP_OK)
                .extract()
                .as(UserCreateResponse.class);
    }

    //Note user editing is not allowed by the another user therefore 403 status code is expected
    public static void updateUser(@NotNull UserPayload userPayload, int userId) {
        log.info("API: Create '{}' project.", userPayload);

        requestNewAccessToken()
                .contentType(ContentType.JSON)
                .basePath(String.format(UPDATE_DELETE_USER_PATH, userId))
                .body(userPayload)
                .put()
                .then()
                .statusCode(HTTP_FORBIDDEN);
    }

    @Step("API: Delete project with id '{0}'")
    public static void deleteUserBy(@NotNull int userId) {
        log.info("API: Delete project with id '{}'", userId);

        requestNewAccessToken()
                .contentType(ContentType.JSON)
                .basePath(String.format(UPDATE_DELETE_USER_PATH, userId))
                .delete();
//                Note: user entity is removed but the error code and msg are in the response
    }

    @Step("API: Get user count")
    public static int getUsersCount() {
        log.info("API: Get user count");
        return getUsers().getCount();
    }

    @Step("API: Is user present with username '{0}'")
    public static boolean isUserPresent(String username) {
        log.info("API: Is user exist with username '{}'", username);
        return Arrays.stream(getUsers().getUser())
                .anyMatch(user -> user.getUsername().equals(username));
    }
}
