package co.kr.metacoding.backendtest.codingtest.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class DTO {
        private int id;
        private String name;

        public DTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}
