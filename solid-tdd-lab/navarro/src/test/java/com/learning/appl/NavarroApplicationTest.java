package com.learning.appl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

class NavarroApplicationTest {

    @Test
    @DisplayName("Main delegates application startup to SpringApplication")
    void mainShouldStartSpringApplication() {
        String[] args = {"--spring.profiles.active=test"};
        ConfigurableApplicationContext context = mock(ConfigurableApplicationContext.class);

        try (MockedStatic<SpringApplication> springApplication = mockStatic(SpringApplication.class)) {
            springApplication
                    .when(() -> SpringApplication.run(NavarroApplication.class, args))
                    .thenReturn(context);

            NavarroApplication.main(args);

            springApplication.verify(() -> SpringApplication.run(NavarroApplication.class, args));
        }
    }
}
