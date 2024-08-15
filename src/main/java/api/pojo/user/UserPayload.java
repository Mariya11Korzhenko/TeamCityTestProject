package api.pojo.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPayload {
    private String username;
    private String password;
    private String email;
    private Roles roles;
    private Groups groups;

    @Data
    @Builder
    public static class Roles {
        private Role[] role;

        @Data
        @Builder
        public static class Role {
            private String roleId;
            private String scope;
        }
    }

    @Data
    @Builder
    public static class Groups {
        private Group[] group;

        @Data
        @Builder
        public static class Group {
            private String key;
        }
    }
}

