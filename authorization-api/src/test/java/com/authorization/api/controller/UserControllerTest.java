package com.authorization.api.controller;

import com.authorization.api.controller.exceptions.ForbiddenException;
import com.authorization.api.model.UserModel;
import com.authorization.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void shouldReturnNotNullObject(){
        UserModel param = new UserModel();
        param.setPassword("hahsgagdad");
        param.setUserName("juan");

        when(userService.isValid(any())).thenReturn(true);
        UserModel response = userController.userAuth(param);

        assertThat(response).isNotNull();
    }

    @Test(expected = ForbiddenException.class)
    public void shouldReturnForbiddenException(){
        when(userService.isValid(any())).thenReturn(false);
        userController.userAuth(new UserModel());
    }


}
