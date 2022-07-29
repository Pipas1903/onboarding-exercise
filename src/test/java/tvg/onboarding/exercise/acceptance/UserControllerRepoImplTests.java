package tvg.onboarding.exercise.acceptance;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tvg.onboarding.exercise.config.DatabaseConfiguration;
import tvg.onboarding.exercise.controller.UserController;
import tvg.onboarding.exercise.converter.UserConverter;
import tvg.onboarding.exercise.dto.UserDetailsDto;
import tvg.onboarding.exercise.persistence.entity.UserEntity;
import tvg.onboarding.exercise.persistence.repository.UserDatabaseUserRepository;
import tvg.onboarding.exercise.persistence.repository.UserRepository;
import tvg.onboarding.exercise.service.UserServiceRepoImpl;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedCreateUserDto;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedUserDetailsDto;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedUserEntity;
import static tvg.onboarding.exercise.mockedData.MockedData.getMockedUserEntityList;

@Slf4j
@ExtendWith({SpringExtension.class})
@ActiveProfiles("production")
@ContextConfiguration(classes = DatabaseConfiguration.class)
@Import({UserController.class,
        UserServiceRepoImpl.class,
        UserConverter.class,
        UserEntity.class,
        UserRepository.class
})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerRepoImplTests {

    @LocalServerPort
    private final int port = 8080;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @MockBean
    private UserDatabaseUserRepository userRepository;

    @Nested
    class getAllUsers {
        @Test
        void shouldReturnUserList() {

            when(userRepository.findAll())
                    .thenReturn(getMockedUserEntityList());

            final var result = given()
                    .port(port)
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/users")
                    .then().extract().response();

            assertEquals(HttpStatus.OK.value(), result.getStatusCode());

            verify(userRepository, times(1))
                    .findAll();

            final var userEntities = result.getBody().as(UserDetailsDto[].class);

            assertEquals(1, userEntities.length);
            assertEquals(getMockedUserDetailsDto().getName(), userEntities[0].getName());
            assertEquals(getMockedUserDetailsDto().getId(), userEntities[0].getId());
        }

        @Test
        void shouldReturnEmptyList() {

            when(userRepository.findAll())
                    .thenReturn(List.of());

            final var result = given()
                    .port(port)
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/users")
                    .then().extract().response();

            assertEquals(HttpStatus.OK.value(), result.getStatusCode());

            verify(userRepository, times(1))
                    .findAll();

            final var userEntities = result.getBody().as(UserDetailsDto[].class);

            assertEquals(0, userEntities.length);
        }

    }

    @Nested
    class addNewUser {
        @Test
        void shouldReturnUserDetails() {

            when(userRepository.save(any()))
                    .thenReturn(getMockedUserEntity());

            final var result = given()
                    .port(port)
                    .body(getMockedCreateUserDto())
                    .contentType(ContentType.JSON)
                    .when()
                    .post("/users")
                    .then().extract().response();

            assertEquals(HttpStatus.OK.value(), result.getStatusCode());

            verify(userRepository, times(1))
                    .save(any());

            final var userEntity = result.getBody().as(UserDetailsDto.class);

            assertNotNull(userEntity);
            assertEquals(getMockedUserDetailsDto().getName(), userEntity.getName());
            assertEquals(getMockedUserDetailsDto().getId(), userEntity.getId());
        }
    }


}
