package co.kr.metacoding.backendtest.codingtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse.DTO join(UserRequest.SaveDTO reqDTO) {
        User userPS = userRepository.save(reqDTO.toEntity());
        return new UserResponse.DTO(userPS);
    }


    public UserResponse.DTO find(Integer id) {
        User userPS = userRepository.getUserById(id);
        return new UserResponse.DTO(userPS);
    }

    @Transactional
    public UserResponse.DTO update(UserRequest.UpdateDTO reqDTO, Integer id) {
        User userPS = userRepository.update(id, reqDTO.getName());
        return new UserResponse.DTO(userPS);
    }
}
