package api;

import api.pojo.project.ProjectCreateResponse;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static api.data.TestApiProjects.TEST_PROJECT_CREATE;
import static api.services.ProjectService.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Epic("Project Tests")
public class ProjectApiTests {

    @Test
    void verifyProjectCreationDeletion() {
        // Get initial project count
        int initialCount = getProjectCount();

        // Create project and verify creation
        ProjectCreateResponse createdProjectResponse = createProject(TEST_PROJECT_CREATE);
        int afterCreationCount = getProjectCount();

        assertThat(afterCreationCount).isEqualTo(initialCount + 1);
        assertThat(isProjectPresent(TEST_PROJECT_CREATE.getId())).isTrue();

        // Delete the created project
        String createdProjectId = createdProjectResponse.getId();
        deleteProject(createdProjectId);

        assertThat(getProjectCount()).isEqualTo(initialCount);
        assertThat(isProjectPresent(TEST_PROJECT_CREATE.getId())).isFalse();
    }
}
