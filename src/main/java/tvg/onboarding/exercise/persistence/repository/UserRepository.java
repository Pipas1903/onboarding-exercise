package tvg.onboarding.exercise.persistence.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tvg.onboarding.exercise.persistence.entity.UserEntity;

@Profile("production")
@Repository
public interface UserRepository extends
        JpaRepository<UserEntity, Long>,
        tvg.onboarding.exercise.persistence.repository.Repository<UserEntity> {
}
