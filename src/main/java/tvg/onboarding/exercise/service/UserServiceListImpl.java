package tvg.onboarding.exercise.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tvg.onboarding.exercise.converter.UserConverter;
import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.dto.UserDetailsDto;
import tvg.onboarding.exercise.persistence.entity.UserEntity;
import tvg.onboarding.exercise.persistence.repository.MockRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Profile("!production")
public class UserServiceListImpl implements UserService {

    private final MockRepository mockRepository;
    private final UserConverter userConverter;

    @Override
    public UserDetailsDto addNewUser(CreateUserDto createUserDto) {
        log.info("default implementation was used");
        UserEntity user = userConverter.convertDtoToUserEntity(createUserDto);
        final var savedUser = mockRepository.save(user);
        log.info("user successfully saved to user list");
        return userConverter.convertEntityToUserDetailsDto(savedUser);
    }

    @Override
    public List<UserDetailsDto> getAllUsers() {
        log.info("default implementation was used");
        final var users = mockRepository.findAll().stream()
                .map(userConverter::convertEntityToUserDetailsDto)
                .collect(Collectors.toList());
        log.info("Retrieved {} users from list", users.size());
        return users;
    }
}
