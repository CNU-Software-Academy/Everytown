package com.example.demo.user.entity;

import com.example.demo.user.dto.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// name, id, pw, nickname
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String password;

    @Column(unique = true)
    private String nickname;

    @Column
    private String email;


    public static User toEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getPassword(), userDto.getNickname(), userDto.getId() + "@cnu.ac.kr");
    }


}