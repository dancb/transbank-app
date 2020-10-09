package com.authorization.api.controller;

import com.authorization.api.controller.exceptions.ForbiddenException;
import com.authorization.api.model.UserModel;
import com.authorization.api.service.UserService;
import com.authorization.api.util.JWTUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @ResponseBody
    public UserModel userAuth(@RequestBody UserModel user) {

        if (userService.isValid(user)) {
            String token = JWTUtils.getJWTToken(user.getUserName());
            user.setToken(token);
            return user;
        }

        throw new ForbiddenException();
    }
}
