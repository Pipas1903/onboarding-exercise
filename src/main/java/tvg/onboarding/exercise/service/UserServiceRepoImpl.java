package tvg.onboarding.exercise.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tvg.onboarding.exercise.converter.UserConverter;
import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.dto.UserDetailsDto;
import tvg.onboarding.exercise.persistence.entity.UserEntity;
import tvg.onboarding.exercise.persistence.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Profile("production")
public class UserServiceRepoImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public UserDetailsDto addNewUser(CreateUserDto createUserDto) {
        log.info("implementation for production was used");
        UserEntity user = userConverter.convertDtoToUserEntity(createUserDto);
        final var savedUser = userRepository.save(user);
        log.info("user successfully saved to database");
        return userConverter.convertEntityToUserDetailsDto(savedUser);
    }

    @Cacheable(cacheNames = "users")
    @Override
    public List<UserDetailsDto> getAllUsers() {
        log.info("implementation for production was used");
        final var users = userRepository.findAll().stream()
                .map(userConverter::convertEntityToUserDetailsDto)
                .collect(Collectors.toList());
        log.info("Retrieved {} users from database", users.size());
        return users;
    }
}
