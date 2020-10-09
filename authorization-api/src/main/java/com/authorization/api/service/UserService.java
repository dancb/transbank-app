package com.authorization.api.service;

import com.authorization.api.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final String encodeUserName;
    private final String encodedPassword;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(@Value("${api.auth.username}") String encodeUserName,
                       @Value("${api.auth.password}") String encodedPassword,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.encodeUserName = encodeUserName;
        this.encodedPassword = encodedPassword;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public boolean isValid(UserModel user){

        boolean isPasswordMatch = bCryptPasswordEncoder.matches(user.getPassword(), encodedPassword);
        boolean isUserNameMatch = bCryptPasswordEncoder.matches(user.getUserName(), encodeUserName);

        if(isPasswordMatch && isUserNameMatch){
            return true;
        }

        return false;
    }

}
