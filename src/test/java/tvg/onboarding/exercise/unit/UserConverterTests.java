package tvg.onboarding.exercise.unit;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import tvg.onboarding.exercise.converter.UserConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedCreateUserDto;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedUserEntity;

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

            assertEquals("eu", result.getName());
            assertNull(result.getId());

        }
    }

}
