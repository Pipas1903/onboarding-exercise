package tvg.onboarding.exercise.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tvg.onboarding.exercise.dto.CreateUserDto;
import tvg.onboarding.exercise.dto.UserDetailsDto;
import tvg.onboarding.exercise.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "Manages user interactions")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Get all users")
    @GetMapping("/users")
    public ResponseEntity<List<UserDetailsDto>> getAllUsers() {
        log.info("Request received to get all users");
        final var users = userService.getAllUsers();
        log.info("Returning all users");
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Create a new user")
    @PostMapping("/users")
    public ResponseEntity<UserDetailsDto> addNewUser(@RequestBody CreateUserDto createUserDto) {
        log.info("Request received to add a new user");
        final var user = userService.addNewUser(createUserDto);
        log.info("Returning created user details");
        return ResponseEntity.ok(user);
    }
}
