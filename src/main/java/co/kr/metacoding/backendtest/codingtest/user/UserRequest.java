package co.kr.metacoding.backendtest.codingtest.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class UserRequest {
    @Data
    public static class SaveDTO {

        @NotBlank(message = "이름은 필수입니다.")
        private String name;

        public User toEntity() {
            return User.builder()
                    .name(this.name)
                    .build();
        }
    }

    @Data
    public static class UpdateDTO {
        @NotBlank(message = "이름은 필수입니다.")
        private String name;
    }
}
