package api.pojo.project;

import lombok.Data;

import java.util.List;

@Data
public class ProjectResponse {
    private int count;
    private String href;
    private List<Project> project;
}
