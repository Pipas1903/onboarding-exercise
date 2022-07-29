package tvg.onboarding.exercise.persistence.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tvg.onboarding.exercise.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Profile("!production")
@Service
public class MockUserRepository implements UserRepository<UserEntity> {
    private final Map<Long, UserEntity> userEntities = new HashMap<>();
    private static Long idGenerator = 0L;

    @Override
    public synchronized UserEntity save(UserEntity userEntity) {
        idGenerator++;
        userEntity.setId(idGenerator);
        userEntities.put(userEntity.getId(), userEntity);
        return userEntities.get(userEntity.getId());
    }

    @Override
    public List<UserEntity> findAll() {
        return new ArrayList<>(userEntities.values());
    }


}
