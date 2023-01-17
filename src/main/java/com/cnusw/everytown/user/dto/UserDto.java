package com.example.demo.user.dto;

import com.example.demo.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String password;
    private String nickname;
    private String email;

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getPassword(), user.getNickname(), user.getEmail());
    }
}
