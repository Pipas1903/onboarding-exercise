package tvg.onboarding.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EntityScan
public class OnboardingExerciseApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(OnboardingExerciseApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OnboardingExerciseApplication.class);
    }
}
