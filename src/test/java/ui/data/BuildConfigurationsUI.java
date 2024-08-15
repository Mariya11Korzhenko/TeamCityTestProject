package ui.data;

import ui.pojo.BuildConfigurationUI;

import static api.data.TestApiProjects.TEST_PROJECT_BUILD_STEPS;
import static api.data.TestApiProjects.TEST_PROJECT_TRIGGER;
import static utils.NumberUtils.generateUniqueTextBasedOnDateToday;

public class BuildConfigurationsUI {
    private static final String CREATE_BUILD_CONFIGURATION_COUNT_TRIGGER_TEST = generateUniqueTextBasedOnDateToday();

    public static final BuildConfigurationUI CREATE_BUILD_CONFIGURATION_UI_TRIGGER_TEST = BuildConfigurationUI
            .builder()
            .projectParentName(TEST_PROJECT_TRIGGER.getName())
            .name("test_build_configuration_ui_name_" + CREATE_BUILD_CONFIGURATION_COUNT_TRIGGER_TEST)
            .buildConfigurationId("test_build_configuration_ui_id_" + CREATE_BUILD_CONFIGURATION_COUNT_TRIGGER_TEST)
            .description("test_build_configuration_ui_description_" + CREATE_BUILD_CONFIGURATION_COUNT_TRIGGER_TEST)
            .build();

    private static final String CREATE_BUILD_CONFIGURATION_COUNT_BUILD_STEPS_TEST = generateUniqueTextBasedOnDateToday();

    public static final BuildConfigurationUI CREATE_BUILD_CONFIGURATION_UI_BUILD_STEPS_TEST = BuildConfigurationUI
            .builder()
            .projectParentName(TEST_PROJECT_BUILD_STEPS.getName())
            .name("test_build_configuration_ui_name_" + CREATE_BUILD_CONFIGURATION_COUNT_BUILD_STEPS_TEST)
            .buildConfigurationId("test_build_configuration_ui_id_" + CREATE_BUILD_CONFIGURATION_COUNT_BUILD_STEPS_TEST)
            .description("test_build_configuration_ui_description_" + CREATE_BUILD_CONFIGURATION_COUNT_BUILD_STEPS_TEST)
            .build();
}
