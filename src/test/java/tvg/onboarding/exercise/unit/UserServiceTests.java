package tvg.onboarding.exercise.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tvg.onboarding.exercise.converter.UserConverter;
import tvg.onboarding.exercise.persistence.entity.UserEntity;
import tvg.onboarding.exercise.persistence.repository.UserRepository;
import tvg.onboarding.exercise.service.UserService;
import tvg.onboarding.exercise.service.UserServiceListImpl;
import tvg.onboarding.exercise.service.UserServiceRepoImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedCreateUserDto;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedUserDetailsDto;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedUserEntity;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedUserEntityList;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository<UserEntity> userRepository;

    @Nested
    class addNewUser {
        private UserService userService;

        @Test
        void shouldReturnNewUserDetailsRepo() {
            this.userService = new UserServiceRepoImpl(userRepository, new UserConverter());

            when(userRepository.save(any()))
                    .thenReturn(getMockedUserEntity());

            final var result = userService.addNewUser(getMockedCreateUserDto());

            assertEquals(getMockedUserDetailsDto().getName(), result.getName());
            assertEquals(getMockedUserDetailsDto().getId(), result.getId());
        }

        @Test
        void shouldReturnNewUserDetailsList() {
            this.userService = new UserServiceListImpl(userRepository, new UserConverter());

            when(userRepository.save(any()))
                    .thenReturn(getMockedUserEntity());

            final var result = userService.addNewUser(getMockedCreateUserDto());

            assertEquals(getMockedUserDetailsDto().getName(), result.getName());
            assertEquals(getMockedUserDetailsDto().getId(), result.getId());
        }
    }

    @Nested
    class getAllUsers {
        private UserService userService;

        @Test
        void shouldReturnUserDetailsListRepo() {
            this.userService = new UserServiceRepoImpl(userRepository, new UserConverter());

            when(userRepository.findAll())
                    .thenReturn(getMockedUserEntityList());

            final var result = userService.getAllUsers();

            assertEquals(getMockedUserDetailsDto().getName(), result.get(0).getName());
            assertEquals(getMockedUserDetailsDto().getId(), result.get(0).getId());
        }

        @Test
        void shouldReturnUserDetailsListList() {
            this.userService = new UserServiceListImpl(userRepository, new UserConverter());

            when(userRepository.findAll())
                    .thenReturn(getMockedUserEntityList());

            final var result = userService.getAllUsers();

            assertEquals(getMockedUserDetailsDto().getName(), result.get(0).getName());
            assertEquals(getMockedUserDetailsDto().getId(), result.get(0).getId());
        }
    }

}
