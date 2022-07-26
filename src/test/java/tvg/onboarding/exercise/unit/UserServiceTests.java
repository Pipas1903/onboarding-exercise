package tvg.onboarding.exercise.unit;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tvg.onboarding.exercise.persistence.repository.UserRepository;
import tvg.onboarding.exercise.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


}
