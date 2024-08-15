package ui.data;

import ui.pojo.ProjectUI;

import static utils.NumberUtils.generateUniqueTextBasedOnDateToday;

public class ProjectsUI {
    private static final String CREATE_PROJECT_COUNT = generateUniqueTextBasedOnDateToday();

    public static final ProjectUI TEST_CREATE_PROJECT_UI = ProjectUI
            .builder()
            .projectParent("TestProject123")
            .name("test_project_ui_name_" + CREATE_PROJECT_COUNT)
            .projectId("test_project_ui_id_" + CREATE_PROJECT_COUNT)
            .description("test_project_ui_description_" + CREATE_PROJECT_COUNT)
            .build();
}
