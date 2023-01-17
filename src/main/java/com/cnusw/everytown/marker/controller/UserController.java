package marker.controller;

import com.example.demo.dto.NicknameDto;
import com.example.demo.dto.PointDto;
import com.example.demo.dto.UserPointDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/create_userName")
    @ResponseBody
    public ResponseEntity createUserName(){
        String tmpName = userService.makeRandomName();
        return ResponseEntity.status(HttpStatus.OK).body(new NicknameDto(tmpName));
    }

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<UserPointDto>> getAllPoints(){
        return ResponseEntity.ok(userService.getAllPoint());
    }

    @PostMapping("/users/save")
    @ResponseBody
    public ResponseEntity saveUserPoint(@RequestBody UserPointDto dto){
        userService.createPoint(dto);
        return ResponseEntity.ok().build();
    }

}
