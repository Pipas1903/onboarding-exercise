package tvg.onboarding.exercise.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.dto.UserDetailsDto;
import tvg.onboarding.exercise.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDetailsDto>> getAllUsers() {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDetailsDto> addNewUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(null);
    }
}
