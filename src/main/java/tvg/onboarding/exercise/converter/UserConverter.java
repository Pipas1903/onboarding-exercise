package tvg.onboarding.exercise.converter;

import org.springframework.stereotype.Component;
import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.dto.UserDetailsDto;
import tvg.onboarding.exercise.persistence.entity.UserEntity;

@Component
public class UserConverter {
    public UserDetailsDto convertEntityToUserDetailsDto(UserEntity user) {
        return UserDetailsDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    public UserEntity convertDtoToUserEntity(CreateUserDto createUserDto) {
        return UserEntity.builder()
                .name(createUserDto.getName())
                .build();
    }
}
