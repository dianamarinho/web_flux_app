package com.poi.pointOfInterest.controller;

import com.poi.pointOfInterest.converters.UserDtoToUser;
import com.poi.pointOfInterest.converters.UserToUserDto;
import com.poi.pointOfInterest.domain.User;
import com.poi.pointOfInterest.dto.UserDto;
import com.poi.pointOfInterest.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootTest
class PoiControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    UserDtoToUser userDtoToUser;

    @Autowired
    UserToUserDto userToUserDto;

    private WebTestClient webTestClient;


    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);

        this.webTestClient =
                WebTestClient.bindToController(new UserController(userService, userToUserDto, userDtoToUser))
                        .configureClient()
                        .baseUrl("/api")
                        .build();
    }
    @Test
    void shouldShowAllUsers() {
        Integer id = 1;
        String name = "Diana";
        String city = "Porto";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setCity(city);

        UserDto userDto = userToUserDto.convertUserIntoUserDto(user);

        Mockito
                .when(userService.getAllUsers())
                .thenReturn(Flux.just(user));

        List<UserDto> userDtoList = List.of(userDto);


        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(UserDto.class)
                .isEqualTo(userDtoList);

    }

    @Test
    void shouldShowOnlyOneUser() {

        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        UserDto userDto = userToUserDto.convertUserIntoUserDto(user);

        Mockito
                .when(userService.getOnlyOneUser(1))
                .thenReturn(Mono.just(user));

        Mono<UserDto> userDtoMono = Mono.just(userDto);

        webTestClient.get().uri("/consult/{id}", userDto.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserDto.class)
                .isEqualTo(userDto);
    }

    @Test
    void shouldAddOneUser() {

        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        UserDto userDto = userToUserDto.convertUserIntoUserDto(user);

        Mockito
                .when(userService.addNewUser(user))
                .thenReturn(Mono.just(user));


        webTestClient
                .post()
                .uri("/adding")
                .bodyValue(user)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(UserDto.class)
                .isEqualTo(userDto);
    }

    @Test
    void shouldDeleteUser() {

        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        Mockito
                .when(userService.deleteOnlyOneUser(user.getId()))
                .thenReturn(Mono.empty());

        webTestClient
                .delete()
                .uri("/delete/{id}", user.getId())
                .exchange();

    }

    @Test
    void shouldDeleteAllUsers() {

        Mockito
                .when(userService.deleteAllUser())
                .thenReturn(Mono.empty());

        webTestClient
                .delete()
                .uri("/delete")
                .exchange();
    }

    @Test
    void shouldUpdateUser() {

        User user = new User();
        user.setId(1);
        user.setName("Diana");
        user.setCity("Porto");

        UserDto userDto = userToUserDto.convertUserIntoUserDto(user);

        Mockito
                .when(userService.updateUser(user.getId(), user))
                .thenReturn(Mono.just(user));

        webTestClient
                .put()
                .uri("/updating/{id}", userDto.getId())
                .bodyValue(user)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(UserDto.class)
                .isEqualTo(userDto);

    }
}