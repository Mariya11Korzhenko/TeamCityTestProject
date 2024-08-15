package api.pojo.user;

import lombok.*;

@Data
@Getter
@NoArgsConstructor
public class UserCreateResponse {
    private String username;
    private int id;
    private String email;
    private String href;
    private Properties properties;
    private Roles roles;
    private Groups groups;

    @Data
    @Getter
    @NoArgsConstructor
    public static class Properties {
        private String href;
        private int count;
        private Property[] property;

        @Data
        @Getter
        @NoArgsConstructor
        public static class Property {
            private String name;
            private String value;
        }
    }

    @Data
    @Getter
    @NoArgsConstructor
    public static class Roles {
        private Role[] role;

        @Data
        @Getter
        @NoArgsConstructor
        public static class Role {
            private String roleId;
            private String scope;
            private String href;
        }
    }

    @Data
    @Getter
    @NoArgsConstructor
    public static class Groups {
        private int count;
        private Group[] group;

        @Data
        @Getter
        @NoArgsConstructor
        public static class Group {
            private String key;
            private String name;
            private String href;
            private String description;
        }
    }
}

