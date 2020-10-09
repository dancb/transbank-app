package com.authorization.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    private String name;
    private String userName;
    private String password;
    private String token;
}
