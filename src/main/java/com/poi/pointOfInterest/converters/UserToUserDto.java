package com.poi.pointOfInterest.converters;

import com.poi.pointOfInterest.domain.User;
import com.poi.pointOfInterest.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
/**
 * A {@link Converter} implementation, responsible for {@link User} to {@link UserDto} tupe conversion
 */
@Component
public class UserToUserDto {

    /**
     * Converts User into User DTO
     *
     * @param user the User
     *
     * @return the User DTO
     */
    public UserDto convertUserIntoUserDto(User user){

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAddressName(user.getAddressName());
        userDto.setCity(user.getCity());
        userDto.setZipCode(user.getZipCode());
        userDto.setUserType(user.getUserType());

        return userDto;
    }
}
