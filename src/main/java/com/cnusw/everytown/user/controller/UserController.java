package com.cnusw.everytown.user.controller;

import com.cnusw.everytown.user.dto.UserDto;
import com.cnusw.everytown.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getAllPoints(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    // endpoint 변경
    @PostMapping("/users/save")
    @ResponseBody
    public ResponseEntity saveUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }


}
