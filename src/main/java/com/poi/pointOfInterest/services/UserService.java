package com.poi.pointOfInterest.services;

import com.poi.pointOfInterest.domain.User;
import com.poi.pointOfInterest.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;

    /**
     * Sets the properties
     *
     * @param userRepository the User repository to set
     */
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * @see UserService#getAllUsers()
     *
     * @return list of User
     */
    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * @see UserService#getOnlyOneUser(Integer)
     *
     * @param id the User id
     *
     * @return the User with that id
     */
    public Mono<User> getOnlyOneUser(Integer id){
        return userRepository.findById(id);
    }

    /**
     * @see UserService#addNewUser(User)
     *
     * @param user the new User
     *
     * @return the added User
     */
    public Mono<User> addNewUser(User user){
        return userRepository.save(user);
    }

    /**
     * @see UserService#deleteOnlyOneUser(Integer)
     *
     * @param id the User to delete
     *
     * @return an empty mono
     */
    public Mono<Void> deleteOnlyOneUser(Integer id){
        return userRepository.deleteById(id);
    }

    /**
     * @see UserService#deleteAllUser()
     *
     * @return an empty mono
     */
    public Mono<Void> deleteAllUser(){
        return userRepository.deleteAll();
    }

    /**
     * @see UserService#updateUser(Integer, User)
     *
     * @param id the id to the User to update
     * @param user the updates to do
     *
     * @return the User updated
     */
    public Mono<User> updateUser(Integer id, User user){
        Mono<User> userMono = getOnlyOneUser(id);
        user.setId(id);
        return userMono.flatMap(user1 -> userRepository.save(user));
    }
}
