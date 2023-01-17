package marker.controller;

import com.example.demo.dto.UserPointDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String indexPage(Model model){
        List<UserPointDto> allPoint = userService.getAllPoint();
        // 가져온 데이터를 model에 등록
        model.addAttribute("allPoints", allPoint);
        return "/index";
    }

}
