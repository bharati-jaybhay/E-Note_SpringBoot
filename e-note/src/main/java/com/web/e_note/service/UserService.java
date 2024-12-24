package com.web.e_note.service;

import com.web.e_note.dto.UserDto;
import com.web.e_note.entity.User;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface UserService{

//    void saveUser(@Valid UserDto userDto);

    List<UserDto> findAllUsers();

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

    void saveUser(UserDto userDto);


}
