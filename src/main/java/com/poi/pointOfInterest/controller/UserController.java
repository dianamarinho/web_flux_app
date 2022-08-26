package com.poi.pointOfInterest.controller;

import com.poi.pointOfInterest.converters.UserDtoToUser;
import com.poi.pointOfInterest.converters.UserToUserDto;
import com.poi.pointOfInterest.domain.User;
import com.poi.pointOfInterest.dto.UserDto;
import com.poi.pointOfInterest.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller responsible for {@link User} related CRUD operations
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private UserToUserDto userToUserDto;
    private UserDtoToUser userDtoToUser;

    /**
     * Sets the params
     * @param userService the Service to set
     * @param userToUserDto the converter to set
     * @param userDtoToUser the converter to set
     */
    public UserController(UserService userService, UserToUserDto userToUserDto, UserDtoToUser userDtoToUser){
        this.userService = userService;
        this.userToUserDto = userToUserDto;
        this.userDtoToUser = userDtoToUser;
    }

    /**
     * Retrieves one flux that represents a list os Users
     *
     * @return the flux with the Users
     */
    @GetMapping
    public Flux<UserDto> seeAllUsers(){
           return userService.getAllUsers().map(user -> userToUserDto.convertUserIntoUserDto(user));
    }

    /**
     * Retrieves a Mono with the User that I want to consult
     *
     * @param id the id of the User
     *
     * @return the mono with the User Dto
     */
    @GetMapping("/consult/{id}")
    public Mono<UserDto> seeOneUser(@PathVariable Integer id){
        return userService.getOnlyOneUser(id).map(user -> userToUserDto.convertUserIntoUserDto(user));
    }

    /**
     * Add a User
     *
     * @param user the User to add
     *
     * @return the User added
     */
    @PostMapping("/adding")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDto> addOnePoi(@RequestBody User user){
        return userService.addNewUser(user).map(user1 -> userToUserDto.convertUserIntoUserDto(user));
    }

    /**
     * Delete one User
     *
     * @param id the User that I want to delete
     *
     * @return an empty mono
     */
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteUser(@PathVariable Integer id){
        return userService.deleteOnlyOneUser(id);
    }

    /**
     * Delete all the User available in the database
     *
     * @return an empty mono
     */
    @DeleteMapping("/delete")
    public Mono<Void> deleteAllUsers(){
        return userService.deleteAllUser();
    }

    /**
     * Update a User
     *
     * @param id the id of the User to update
     * @param user the updates to do in the User
     *
     * @return the updated User
     */
    @PutMapping("/updating/{id}")
    public Mono<UserDto> updatePoi(@PathVariable Integer id, @RequestBody User user){
        return userService.updateUser(id, user).map(pointOfInterest1 -> userToUserDto.convertUserIntoUserDto(user));
    }

}
