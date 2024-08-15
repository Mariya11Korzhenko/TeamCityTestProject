package api.pojo.project;

import lombok.Data;

@Data
public class ProjectCreateResponse {
    private String id;
    private String name;
    private String parentProjectId;
    private boolean virtual;
    private String href;
    private String webUrl;
    private ParentProject parentProject;
    private BuildTypes buildTypes;
    private Templates templates;
    private DeploymentDashboards deploymentDashboards;
    private Parameters parameters;
    private VcsRoots vcsRoots;
    private ProjectFeatures projectFeatures;
    private Projects projects;

    // Nested classes for the various parts of the JSON response
    @Data
    public static class ParentProject {
        private String id;
        private String name;
        private String description;
        private String href;
        private String webUrl;
        private String parentProjectId;
    }

    @Data
    public static class BuildTypes {
        private int count;
        private BuildType[] buildType;
    }

    @Data
    public static class BuildType {
        // Add fields if needed based on the actual response structure for buildType
    }

    @Data
    public static class Templates {
        private int count;
        private BuildType[] buildType;  // Assuming it's similar to buildTypes
    }

    @Data
    public static class DeploymentDashboards {
        private int count;
    }

    @Data
    public static class Parameters {
        private String href;
        private int count;
        private Parameter[] property;
    }

    @Data
    public static class Parameter {
        // Add fields if needed based on the actual response structure for parameter
    }

    @Data
    public static class VcsRoots {
        private int count;
        private String href;
    }

    @Data
    public static class ProjectFeatures {
        private int count;
        private String href;
    }

    @Data
    public static class Projects {
        private int count;
    }
}
