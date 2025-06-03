package co.kr.metacoding.backendtest.codingtest.user;

import co.kr.metacoding.backendtest.codingtest._core.error.ex.ExceptionApi400;
import co.kr.metacoding.backendtest.codingtest._core.error.ex.ExceptionApi404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse.SaveDTO joinUser(UserRequest.DTO reqDTO) {
        User foundUser = userRepository.findUserByName(reqDTO.getName());
        // if (findUser != null) throw new ExceptionApi400("이미 존재하는 회원입니다");
        User user = reqDTO.toEntity(reqDTO.getName());
        User userPS = userRepository.save(user);
        return new UserResponse.SaveDTO(userPS);
    }


    public UserResponse.DTO getUser(long userId) {
        User userPS = userRepository.findUserById(userId);
        // if (userPS == null) throw new ExceptionAPI404("해당하는 유저를 찾을 수 없습니다.");
        return new UserResponse.DTO(userPS);
    }

    @Transactional
    public UserResponse.DTO updateUser(UserRequest.DTO reqDTO, long userId) {
        User userPS = userRepository.findUserById(userId);
        // if (userPS == null) throw new ExceptionApi404("해당하는 유저를 찾을 수 없습니다.");

        User foundUser = userRepository.findUserByName(reqDTO.getName());
        // if (foundUser != null) throw new Exception400("이미 해당 이름을 가진 유저가 존재합니다.");

        userPS.update(reqDTO.getName());

        return new UserResponse.DTO(userPS);
    }
}
