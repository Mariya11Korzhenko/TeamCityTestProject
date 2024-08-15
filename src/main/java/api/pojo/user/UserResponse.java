package api.pojo.user;

import lombok.Data;

@Data
public class UserResponse {
    private int count;
    private User[] user;

    @Data
    public static class User {
        private String username;
        private String name;
        private int id;
        private String href;
    }
}

