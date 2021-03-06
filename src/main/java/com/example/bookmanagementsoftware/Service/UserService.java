package com.example.bookmanagementsoftware.Service;

import com.example.bookmanagementsoftware.Model.User;
import com.example.bookmanagementsoftware.Repositroy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUsers(User user){
        userRepository.save(user);
    }

}
