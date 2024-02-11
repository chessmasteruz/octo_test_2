package uz.rovshan.testtask2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.rovshan.testtask2.model.User;
import uz.rovshan.testtask2.service.UserInfoService;

import java.util.List;

@RestController
@RequestMapping("api/v1.0")
public class UserController {

    private final UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("user-info")
    public List<User> userInfo(){
        return userInfoService.userInfo();
    }
}
