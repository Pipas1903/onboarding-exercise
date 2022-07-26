package tvg.onboarding.exercise.mockedData;

import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.dto.UserDetailsDto;
import tvg.onboarding.exercise.persistence.entity.UserEntity;

import java.util.Collections;
import java.util.List;

public class MockedData {
    public static UserEntity getMockedUserEntity() {
        return UserEntity.builder()
                .id(1L)
                .name("eu")
                .build();
    }

    public static CreateUserDto getMockedCreateUserDto() {
        return CreateUserDto.builder()
                .name("eu")
                .build();
    }

    public static UserDetailsDto getMockedUserDetailsDto(){
        return UserDetailsDto.builder()
                .name("eu")
                .id(1L)
                .build();
    }

    public static List<UserEntity> getMockedUserEntityList(){
        return Collections.singletonList(getMockedUserEntity());
    }
}
