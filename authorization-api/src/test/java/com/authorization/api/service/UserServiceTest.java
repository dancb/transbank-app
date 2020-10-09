package com.authorization.api.service;

import com.authorization.api.model.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static String PASS = "$2a$10$qpQGcCNpBD6qW/JE/uGfWuZYIjx6WDNhSYPxzeQ1tPqRJOSJmsoAq";
    private static String US   = "$2a$10$4F79/Fn0juVPrcaNZgopj.U7gZOqw3BLIBVVEzglHrY2A4PFR5U.y";

    @InjectMocks
    private UserService userService;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp() {
        userService = new UserService(US, PASS, bCryptPasswordEncoder);
    }

    @Test
    public void shouldReturnTrue(){
        UserModel param = new UserModel();
        param.setPassword("test_transbank.2020");
        param.setUsername("transkan_user");

        when(bCryptPasswordEncoder.matches(param.getPassword(), PASS)).thenReturn(true);
        when(bCryptPasswordEncoder.matches(param.getUsername(), US)).thenReturn(true);
        boolean res = userService.isValid(param);

        assertThat(res).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalse(){
        UserModel param = new UserModel();
        param.setPassword("dsdsdsd");
        param.setUsername("carlos");

        when(bCryptPasswordEncoder.matches(param.getPassword(), PASS)).thenReturn(false);
        when(bCryptPasswordEncoder.matches(param.getUsername(), US)).thenReturn(false);
        boolean res = userService.isValid(param);

        assertThat(res).isEqualTo(false);
    }
}
