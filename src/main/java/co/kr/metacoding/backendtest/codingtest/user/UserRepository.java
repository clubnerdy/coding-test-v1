package co.kr.metacoding.backendtest.codingtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public User getUserById(Integer id) {
        User user = em.find(User.class, id);
        return user;
    }

    public User update(Integer id, String username) {
        User user = em.find(User.class, id);
        user.update(username);
        return user;
    }
}
