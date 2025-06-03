package co.kr.metacoding.backendtest.codingtest.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class UserRequest {

    @Data
    public static class DTO {
        private String name;

        public User toEntity(String username) {
            return User.builder().name(username).build();
        }
    }
}
