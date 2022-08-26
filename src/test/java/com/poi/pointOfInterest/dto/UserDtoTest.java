package com.poi.pointOfInterest.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDtoTest {

    @Test
    void testToString() {
        UserDto userDto = new UserDto();
        userDto.setName("Diana");

        String expectedId = "Diana";

        assertEquals(expectedId, userDto.getName());
    }

    @Test
    void testHashCode() {
        UserDto userDto = new UserDto();
        userDto.setId(1);

        UserDto userDto1 = new UserDto();
        userDto1.setId(1);

        assertEquals(userDto, userDto1);
    }
}