package tvg.onboarding.exercise.persistence.repository;

import tvg.onboarding.exercise.persistence.entity.UserEntity;

import java.util.List;

public interface UserRepository<T> {
    List<T> findAll();
    UserEntity save(UserEntity userEntity);
}
