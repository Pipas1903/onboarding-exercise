package tvg.onboarding.exercise.persistence.repository;

import org.springframework.stereotype.Service;
import tvg.onboarding.exercise.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MockRepository {
    private final Map<Long, UserEntity> userEntities = new HashMap<>();
    private static Long idGenerator = 0L;

    public UserEntity addNewUser(UserEntity userEntity) {
        idGenerator++;
        userEntity.setId(idGenerator);
        userEntities.put(userEntity.getId(), userEntity);
        return userEntities.get(userEntity.getId());
    }

    public List<UserEntity> getAllUsers() {
        return new ArrayList<>(userEntities.values());
    }

}
