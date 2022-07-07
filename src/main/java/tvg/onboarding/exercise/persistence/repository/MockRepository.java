package tvg.onboarding.exercise.persistence.repository;

import org.springframework.stereotype.Repository;
import tvg.onboarding.exercise.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MockRepository {
    private final Map<Long, UserEntity> userEntities = new HashMap<>();

    public UserEntity addNewUser(UserEntity userEntity) {
        userEntities.put(userEntity.getId(), userEntity);
        return userEntities.get(userEntity.getId());
    }

    public List<UserEntity> getAllUsers() {
        return new ArrayList<>(userEntities.values());
    }

}
