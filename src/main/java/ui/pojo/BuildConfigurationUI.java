package ui.pojo;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@Builder
public class BuildConfigurationUI {
    @NotNull
    String projectParentName;
    @NotNull
    String  name;
    @NotNull
    String buildConfigurationId;
    String description;
}
