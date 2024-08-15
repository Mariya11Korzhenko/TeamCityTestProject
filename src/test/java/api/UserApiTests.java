package api;

import api.pojo.user.UserCreateResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static api.data.TestApiUsers.TEST_USER_CREATE;
import static api.data.TestApiUsers.TEST_USER_UPDATE;
import static api.services.UserService.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Epic("User Tests")
public class UserApiTests {

    @Test
    void verifyUserCreationDeletionTest() {
        // Get initial project count
        int initialCount = getUsersCount();

        // Create project and verify creation
        UserCreateResponse createdUserResponse = createUser(TEST_USER_CREATE);
        int afterCreationCount = getUsersCount();

        assertThat(afterCreationCount).isEqualTo(initialCount + 1);
        assertThat(isUserPresent(TEST_USER_CREATE.getUsername())).isTrue();

        // Delete the created project
        int createdUserId = createdUserResponse.getId();
        deleteUserBy(createdUserId);

        assertThat(getUsersCount()).isEqualTo(initialCount);
        assertThat(isUserPresent(TEST_USER_CREATE.getUsername())).isFalse();
    }

    @Test
    void verifyUserUpdateTest() {
        // Get initial project count
        int initialCount = getUsersCount();

        // Create project and verify creation
        UserCreateResponse createdUserResponse = createUser(TEST_USER_CREATE);
        int afterCreationCount = getUsersCount();

        assertThat(afterCreationCount).isEqualTo(initialCount + 1);
        assertThat(isUserPresent(TEST_USER_CREATE.getUsername())).isTrue();

        //Note user editing is not allowed by the another user therefore 403 status code is expected
        updateUser(TEST_USER_UPDATE, createdUserResponse.getId());

        // Delete the created project
        int createdUserId = createdUserResponse.getId();
        deleteUserBy(createdUserId);

        assertThat(getUsersCount()).isEqualTo(initialCount);
        assertThat(isUserPresent(TEST_USER_CREATE.getUsername())).isFalse();
    }
}
