package api.data;

import api.pojo.project.ProjectPayload;

import static utils.NumberUtils.generateUniqueTextBasedOnDateToday;

public class TestApiProjects {

    private static final String CREATE_PROJECT_COUNT = generateUniqueTextBasedOnDateToday();

    public static final ProjectPayload TEST_PROJECT_CREATE = ProjectPayload.builder()
            .parentProject(ProjectPayload.ParentProjectCreate.builder().locator("id:_Root").build())
            .name("TestProject_name_" + CREATE_PROJECT_COUNT)
            .id("TestProject_id_" + CREATE_PROJECT_COUNT)
            .copyAllAssociatedSettings(true)
            .build();

    private static final String CREATE_PROJECT_TRIGGER_COUNT = generateUniqueTextBasedOnDateToday();

    public static final ProjectPayload TEST_PROJECT_TRIGGER = ProjectPayload.builder()
            .parentProject(ProjectPayload.ParentProjectCreate.builder().locator("id:TestProject123").build())
            .name("TestProject_name_" + CREATE_PROJECT_TRIGGER_COUNT)
            .id("TestProject_id_" + CREATE_PROJECT_TRIGGER_COUNT)
            .copyAllAssociatedSettings(true)
            .build();

    private static final String CREATE_PROJECT_BUILD_STEPS_COUNT = generateUniqueTextBasedOnDateToday();

    public static final ProjectPayload TEST_PROJECT_BUILD_STEPS = ProjectPayload.builder()
            .parentProject(ProjectPayload.ParentProjectCreate.builder().locator("id:TestProject123").build())
            .name("TestProject_name_" + CREATE_PROJECT_BUILD_STEPS_COUNT)
            .id("TestProject_id_" + CREATE_PROJECT_BUILD_STEPS_COUNT)
            .copyAllAssociatedSettings(true)
            .build();
}
