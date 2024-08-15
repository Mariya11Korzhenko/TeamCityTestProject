package api.pojo.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectPayload {
    private ParentProjectCreate parentProject;
    private String name;
    private String id;
    private boolean copyAllAssociatedSettings;

    @Data
    @Builder
    public static class ParentProjectCreate {
        private String locator;
    }
}
