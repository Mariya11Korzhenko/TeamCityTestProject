package api.data;

import api.pojo.user.UserPayload;

import static utils.NumberUtils.generateUniqueTextBasedOnDateToday;

public class TestApiUsers {

    private static final String CREATE_USER_COUNT = generateUniqueTextBasedOnDateToday();
    private static final String UPDATE_USER_COUNT = generateUniqueTextBasedOnDateToday();


    private static final UserPayload.Roles.Role CREATE_USER_ROLE = UserPayload.Roles.Role.builder()
            .roleId("SYSTEM_ADMIN")
            .scope("g")
            .build();

    private static final UserPayload.Roles CREATE_USER_ROLES = UserPayload.Roles.builder()
            .role(new UserPayload.Roles.Role[]{CREATE_USER_ROLE})
            .build();

    private static final UserPayload.Groups.Group CREATE_USER_GROUP = UserPayload.Groups.Group.builder()
            .key("ALL_USERS_GROUP")
            .build();

    // Create a Groups object containing the Group array
    private static final UserPayload.Groups CREATE_USER_GROUPS = UserPayload.Groups.builder()
            .group(new UserPayload.Groups.Group[]{CREATE_USER_GROUP})
            .build();

    public static final UserPayload TEST_USER_CREATE = UserPayload.builder()
            .username("test_username_" + CREATE_USER_COUNT)
            .password("test_password_" + CREATE_USER_COUNT)
            .email("test_email" + CREATE_USER_COUNT)
            .roles(CREATE_USER_ROLES)
            .groups(CREATE_USER_GROUPS)
            .build();

    public static final UserPayload TEST_USER_UPDATE = UserPayload.builder()
            .username("test_username_" + UPDATE_USER_COUNT)
            .password("test_password_" + UPDATE_USER_COUNT)
            .email("test_email" + UPDATE_USER_COUNT)
            .roles(CREATE_USER_ROLES)
            .groups(CREATE_USER_GROUPS)
            .build();


}
