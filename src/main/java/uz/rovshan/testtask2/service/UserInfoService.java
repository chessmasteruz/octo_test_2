package uz.rovshan.testtask2.service;

import org.springframework.stereotype.Service;
import uz.rovshan.testtask2.model.User;
import uz.rovshan.testtask2.repository.UserRepository;

import java.util.List;

@Service
public class UserInfoService {

    private final UserRepository userRepository;

    public UserInfoService(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    public List<User> userInfo(){
        return userRepository.findAll();
    }
}
