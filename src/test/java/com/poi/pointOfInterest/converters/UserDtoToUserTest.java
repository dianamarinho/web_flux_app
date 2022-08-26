package com.poi.pointOfInterest.converters;

import com.poi.pointOfInterest.domain.User;
import com.poi.pointOfInterest.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class UserDtoToUserTest {

    @InjectMocks
    UserDtoToUser userDtoToUser;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convertPoiDtoIntoPoi() {
        Integer id = 1;
        String name = "Diana";
        String city = "Porto";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setCity(city);

        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setCity(city);

        Mono<User> userMono = Mono.just(userDtoToUser.convertUserDtoIntoUser(userDto));

        StepVerifier
                .create(userMono)
                .consumeNextWith(user1 -> assertEquals(user1.getId(), userDto.getId()))
                .verifyComplete();
    }
}