package tvg.onboarding.exercise.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tvg.onboarding.exercise.persistence.repository.UserDatabaseUserRepository;
import tvg.onboarding.exercise.persistence.repository.UserRepository;

@Configuration
@EnableAutoConfiguration
@EnableCaching
@EnableJpaRepositories(basePackages = "tvg")
//@EnableJpaRepositories(basePackageClasses = {UserRepository.class, UserDatabaseUserRepository.class})
@Profile("production")
public class DatabaseConfiguration {
}
