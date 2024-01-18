package net.javaguides.amd.service.impl;

import net.javaguides.amd.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto updatedUser);
    void deleteUser(Long userId);
    // Additional methods
    List<UserDto> getUsersByEmail(String email);
    boolean isUserNameAvailable(String userName);

}

//buisness logic