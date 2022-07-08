package tvg.onboarding.exercise.service;

import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.dto.UserDetailsDto;

import java.util.List;

public interface UserService {
    UserDetailsDto addNewUser(CreateUserDto createUserDto);

    List<UserDetailsDto> getAllUsers();
}
