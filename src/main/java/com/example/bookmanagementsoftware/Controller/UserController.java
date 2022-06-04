package com.example.bookmanagementsoftware.Controller;

import com.example.bookmanagementsoftware.DTO.Api;
import com.example.bookmanagementsoftware.Model.User;
import com.example.bookmanagementsoftware.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @PostMapping
    private ResponseEntity<Api> addUsers(@RequestBody @Valid User user){
        userService.addUsers(user);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("User added !", 200));
    }
}
