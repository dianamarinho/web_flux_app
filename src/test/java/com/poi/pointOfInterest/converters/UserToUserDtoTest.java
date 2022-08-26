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
class UserToUserDtoTest {

    @InjectMocks
    UserToUserDto userToUserDto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void convertUserIntoUserDto() {
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

        Mono<UserDto> userDtoMono = Mono.just(userToUserDto.convertUserIntoUserDto(user));

        StepVerifier
                .create(userDtoMono)
                .consumeNextWith(userDto1 -> assertEquals(user.getId(), userDto1.getId()))
                .verifyComplete();
    }
}