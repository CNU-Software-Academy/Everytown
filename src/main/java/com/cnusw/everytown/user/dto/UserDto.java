package com.cnusw.everytown.user.dto;

import com.cnusw.everytown.user.entity.User;
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
