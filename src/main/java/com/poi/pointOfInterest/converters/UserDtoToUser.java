package com.poi.pointOfInterest.converters;

import com.poi.pointOfInterest.domain.User;
import com.poi.pointOfInterest.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

/**
 * A {@link Converter} implementation, responsible for {@link UserDto} to {@link User} type conversion
 */
@Component
public class UserDtoToUser {

    /**
     * Converts the User DTO into a User domain object
     *
     * @param userDto the User DTO
     *
     * @return the User
     */
    public User convertUserDtoIntoUser(UserDto userDto){

        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAddressName(userDto.getAddressName());
        user.setCity(userDto.getCity());
        user.setZipCode(userDto.getZipCode());
        user.setUserType(userDto.getUserType());

        return user;
    }
}
