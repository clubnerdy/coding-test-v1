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
    public ResponseEntity<?> join(@Valid @RequestBody UserRequest.SaveDTO reqDTO) {
        UserResponse.DTO respDTO = userService.join(reqDTO);
        return Resp.ok(Map.of("id", respDTO.getId()));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        UserResponse.DTO respDTO = userService.find(id);
        return ResponseEntity.ok(respDTO);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UserRequest.UpdateDTO reqDTO) {
        UserResponse.DTO respDTO = userService.update(reqDTO, id);
        return Resp.ok(respDTO);
    }
}
