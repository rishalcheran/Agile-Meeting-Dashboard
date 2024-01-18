
package net.javaguides.amd.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.amd.dto.UserDto;
import net.javaguides.amd.entity.User;
import net.javaguides.amd.exception.MeetingNotFoundException;
import net.javaguides.amd.mapper.UserMapper;
import net.javaguides.amd.repository.UserRepository;
import net.javaguides.amd.service.impl.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new MeetingNotFoundException("User does not exist with the given id: " + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new MeetingNotFoundException("User does not exist with given id: " + userId)
        );

        // Update user fields as needed
        user.setUserName(updatedUser.getUserName());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());

        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new MeetingNotFoundException("User does not exist with given id: " + userId)
        );
        userRepository.deleteById(userId);
    }

    // Additional methods
    @Override
    public List<UserDto> getUsersByEmail(String email) {
        List<User> users = userRepository.findByEmail(email);
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isUserNameAvailable(String userName) {
        return !userRepository.findByUserName(userName).isPresent();
    }
}
