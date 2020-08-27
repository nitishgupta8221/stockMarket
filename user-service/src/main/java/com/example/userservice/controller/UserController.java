package com.example.userservice.controller;

import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.sahred.UserRequestModel;
import com.example.userservice.sahred.UserResponseModel;
import com.example.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel)
    {
        return new ResponseEntity<UserResponseModel>(userService.createNewUser(userRequestModel), HttpStatus.CREATED);
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseModel>> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    
    @GetMapping("/users/{userName}")
    public ResponseEntity<UserResponseModel> getUserByUserId(@PathVariable("userName") String userName) throws UserNotFoundException {
        UserResponseModel userResponseModel=userService.findByUserName(userName);
        if (userResponseModel==null)
        {
            throw new UserNotFoundException("user not found with userName "+ userName);
        }
        return new ResponseEntity<UserResponseModel>(userService.findByUserName(userName),HttpStatus.FOUND);
    }
}
