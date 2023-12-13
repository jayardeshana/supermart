package com.supermart.module.user.controller;

import com.supermart.exception.InvalidEmailException;
import com.supermart.exception.InvalidMobileException;
import com.supermart.model.RestResponce;
import com.supermart.module.user.service.IUserService;
import com.supermart.module.user.transfer.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/create")
    RestResponce createUser(@RequestBody SignupRequest signupRequest) throws InvalidEmailException, InvalidMobileException {
       String responce = userService.createUser(signupRequest);
       return new RestResponce(responce);
    }

}
