package co.kr.metacoding.backendtest.codingtest.user;

import co.kr.metacoding.backendtest.codingtest._core.util.Resp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> joinUser(@RequestBody UserRequest.DTO reqDTO) {
        UserResponse.SaveDTO respDTO = userService.joinUser(reqDTO);
        return Resp.ok(respDTO);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        UserResponse.DTO respDTO = userService.getUser(id);
        return Resp.ok(respDTO);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserRequest.DTO reqDTO) {
        UserResponse.DTO respDTO = userService.updateUser(reqDTO, id);
        return Resp.ok(respDTO);
    }
}
