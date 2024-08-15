package ui.pojo;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@Builder
public class ProjectUI {
    @NotNull
    String projectParent;
    @NotNull
    String  name;
    @NotNull
    String projectId;
    String description;
}
