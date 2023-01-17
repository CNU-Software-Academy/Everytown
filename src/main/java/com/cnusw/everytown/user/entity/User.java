package com.cnusw.everytown.user.entity;

import com.cnusw.everytown.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
