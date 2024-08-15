package api.services;

import api.pojo.project.ProjectCreateResponse;
import api.pojo.project.ProjectPayload;
import api.pojo.project.ProjectResponse;
import core.enums.User;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static api.services.AuthService.requestNewAccessToken;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static java.net.HttpURLConnection.HTTP_OK;

@Slf4j

public class ProjectService {
    private static final String PROJECT_PATH = "/app/rest/projects";
    private static final String DELETE_PROJECT_PATH = "/app/rest/projects/id:%s";

    @Step("API: Get projects.")
    public static ProjectResponse getProjects() {
        log.info("API: Get projects.");

        return requestNewAccessToken()
                .basePath(PROJECT_PATH)
                .get()
                .then()
                .statusCode(HTTP_OK)
                .extract()
                .as(ProjectResponse.class);
    }

    @Step("API: Create project {0}.")
    public static ProjectCreateResponse createProject(@NotNull ProjectPayload projectPayload) {
        log.info("API: Create '{}' project", projectPayload);

        return requestNewAccessToken()
                .contentType(ContentType.JSON)
                .basePath(PROJECT_PATH)
                .body(projectPayload)
                .post()
                .then()
                .statusCode(HTTP_OK)
                .extract()
                .as(ProjectCreateResponse.class);
    }

    @Step("API: Delete project with id '{0}'.")
    public static void deleteProject(@NotNull String projectId) {
        log.info("API: Delete project with id '{}'", projectId);

        requestNewAccessToken()
                .contentType(ContentType.JSON)
                .basePath(String.format(DELETE_PROJECT_PATH, projectId))
                .delete()
                .then()
                .statusCode(HTTP_NO_CONTENT);
    }

    @Step("API: Get project count.")
    public static int getProjectCount() {
        log.info("API: Get project count.");
        return getProjects().getCount();
    }

    public static  boolean isProjectPresent(String projectId) {
        log.info("API: Is project exist with projectId '{}'", projectId);
        return getProjects().getProject().stream()
                .anyMatch(project -> project.getId().equals(projectId));
    }
}
