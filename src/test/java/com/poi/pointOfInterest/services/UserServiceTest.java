package com.poi.pointOfInterest.services;

import com.poi.pointOfInterest.domain.User;
import com.poi.pointOfInterest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @MockBean
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllTheUserInDatabase() {

        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");
        User user1 = new User();
        user.setId(2);
        user.setName("Sofia");
        user.setCity("Porto");

        Mockito
                .when(userRepository.findAll())
                .thenReturn(Flux.just(user, user1));

        Flux<User> pointOfInterestFlux = userService.getAllUsers();

        StepVerifier
                .create(pointOfInterestFlux)
                .expectNextCount(2)
                .verifyComplete();


    }

    @Test
    void shouldGetOnlyOneUserById() {

        Integer id = 1;
        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        Mockito
                .when(userRepository.findById(1))
                .thenReturn(Mono.just(user));

        Mono<User> userMono = userService.getOnlyOneUser(1);

        StepVerifier
                .create(userMono)
                .consumeNextWith(user1 -> assertEquals(user.getId(), user1.getId()))
                .verifyComplete();
    }

    @Test
    void shouldAddOneUserToDatabase() {
        Integer id = 1;
        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        Mockito
                .when(userRepository.save(user))
                .thenReturn(Mono.just(user));

        Mono<User> userMono = userService.addNewUser(user);

        StepVerifier
                .create(userMono)
                .consumeNextWith(user1 -> assertEquals(user.getId(), user1.getId()))
                .verifyComplete();

    }

    @Test
    void shouldDeleteOneUserFromDatabase() {

        Integer id = 1;
        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        Mockito
                .when(userRepository.deleteById(1))
                .thenReturn(Mono.empty());

        Mono<Void> mono = userService.deleteOnlyOneUser(id);

        StepVerifier
                .create(mono)
                .verifyComplete();
    }

    @Test
    void shouldDeleteAllUserFromDatabase() {
        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        Mockito
                .when(userRepository.deleteAll())
                .thenReturn(Mono.empty());

        Mono<Void> mono = userService.deleteAllUser();

        StepVerifier
                .create(mono)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void shouldUpdateOneUserByIdAndUpdate() {

        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        Mockito
                .when(userRepository.findById(user.getId()))
                .thenReturn(Mono.just(user));
        Mockito
                .when(userRepository.save(user))
                .thenReturn(Mono.just(user));

        Mono<User> userMono = userService.updateUser(user.getId(), user);

        StepVerifier
                .create(userMono)
                .consumeNextWith(user1 -> assertEquals(user1.hashCode(), user.hashCode()))
                .verifyComplete();
    }
}