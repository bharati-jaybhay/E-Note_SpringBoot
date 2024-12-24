package com.web.e_note.service;

import com.web.e_note.dto.UserDto;
import com.web.e_note.dto.UserMapper;
import com.web.e_note.entity.Role;
import com.web.e_note.entity.User;
import com.web.e_note.repository.RoleRepository;
import com.web.e_note.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void saveUser(UserDto userDto) {
        // Ensure Password is encoded
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);

        // Map UserDto to User entity
        User user = UserMapper.mapToUser(userDto);

        // Assign ROLE_USER if exists or create one
        Role role = roleRepository.findByName("ROLE_USER");
        if (role == null) {
            role = checkRoleExist();
        }
        userDto.setRoles(Collections.singletonList(role));

        // Save the User
        userRepository.save(user);
        System.out.println("Saved User: " + userDto);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setRoleName("ROLE_USER");
        return roleRepository.save(role);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public Optional<User> findUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
