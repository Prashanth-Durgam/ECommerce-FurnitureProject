package com.niit.UserAuthentication.controller;


import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.PasswordMisMatchException;
import com.niit.UserAuthentication.exception.UserAlreadyExistsException;
import com.niit.UserAuthentication.service.ITokenGenerator;
import com.niit.UserAuthentication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ITokenGenerator tokenGenerator;


    @PostMapping("/register") //http://localhost:8082/v1/log/register
    public ResponseEntity<?> UserRegistration(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveRegistration(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody User u) throws PasswordMisMatchException {
        Map<String, String> error = new HashMap<>();
        error.put("message","invalid");
        User data = userService.login(u.getEmail(),u.getPassword()); //getting gmail and password from client and calling service method
        if(data!=null){
            Map<String, String> map =  tokenGenerator.tokenGenerator(data);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}
