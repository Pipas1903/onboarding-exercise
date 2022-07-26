package tvg.onboarding.exercise.unit;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import tvg.onboarding.exercise.converter.UserConverter;
import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.persistence.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class UserConverterTests {

    @InjectMocks
    private UserConverter userConverter;

    @Nested
    class convertEntityToUserDetailsDto {
        @Test
        void shouldReturnUserDetails() {
            final var result = userConverter.convertEntityToUserDetailsDto(getMockedUserEntity());

            assertEquals("eu", result.getName());
            assertEquals(1L, result.getId());
        }
    }

    @Nested
    class convertDtoToUserEntity {

        @Test
        void shouldReturnUserEntity() {
            final var result = userConverter.convertDtoToUserEntity(getMockedCreateUserDto());

            assertEquals("nome", result.getName());
            assertNull(result.getId());

        }
    }

    private UserEntity getMockedUserEntity() {
        return UserEntity.builder()
                .id(1L)
                .name("eu")
                .build();
    }

    private CreateUserDto getMockedCreateUserDto() {
        return CreateUserDto.builder()
                .name("nome")
                .build();
    }

}
