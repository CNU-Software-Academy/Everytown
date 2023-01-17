package com.example.demo.user.service;

import com.example.demo.user.dto.UserDto;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        User user = User.toEntity(userDto);
        userRepository.save(user);
    }

    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> dtos = userList.stream().map(UserDto::toDto).collect(Collectors.toList());
        return dtos;
    }
}
