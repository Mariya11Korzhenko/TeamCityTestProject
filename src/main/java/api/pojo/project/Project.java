package api.pojo.project;

import lombok.Data;

@Data
public class Project {
    private String id;
    private String name;
    private String parentProjectId;
    public String description;
    private String href;
    private String webUrl;
}
