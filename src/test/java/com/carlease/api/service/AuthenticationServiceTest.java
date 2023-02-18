package com.carlease.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import com.carlease.api.config.JwtService;
import com.carlease.api.entity.User;
import com.carlease.api.model.AuthenticationRequest;
import com.carlease.api.model.AuthenticationResponse;
import com.carlease.api.model.RegisterUserRequest;
import com.carlease.api.model.RegisterUserResponse;
import com.carlease.api.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class AuthenticationServiceTest {

  @Mock
  UserRepository repositoryMock;
  @Mock
  JwtService jwtServiceMock;
  @Mock
  AuthenticationManager authenticationManagerMock;
  @Mock
  PasswordEncoder PasswordEncoderMock;
  @Mock
  AuthenticationManager authenticationManager;

  @InjectMocks
  AuthenticationService authenticationService;




  @Test
  public void register_CreateNewUser_ReturnJwtToken() {

    String generate_jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTYW50b3NoIiwiaWF0IjoxNjc2NjU1MzcyLCJleHAiOjE2NzY2NTY4MTJ9.UNxdVIu-GCIvOedk3PAzCqMN0woWupJGkCrf21an5Tc";

    lenient().when(jwtServiceMock.generateToken(any())).thenReturn(generate_jwt);

    RegisterUserRequest registerUserRequest = new RegisterUserRequest();
    registerUserRequest.setUserName("testuser");
    registerUserRequest.setPassword("test123");

    RegisterUserResponse jwt = authenticationService.register(registerUserRequest);

    assertEquals(generate_jwt, jwt.getResponse());

  }


  @Test
  public void authenticate_isUserAutehnticate_TRUE() {

    String generate_jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTYW50b3NoIiwiaWF0IjoxNjc2NjU1MzcyLCJleHAiOjE2NzY2NTY4MTJ9.UNxdVIu-GCIvOedk3PAzCqMN0woWupJGkCrf21an5Tc";

    User userDummy = new User();
    userDummy.setUserName("test");
    Optional<User> userOptional = Optional.of(userDummy);

    lenient().when(jwtServiceMock.generateToken(any())).thenReturn(generate_jwt);
    lenient().when(repositoryMock.findByUserName(any())).thenReturn(userOptional);

    AuthenticationRequest authenticationRequest = new AuthenticationRequest();
    authenticationRequest.setUserName("testuser");
    authenticationRequest.setPassword("test123");

    AuthenticationResponse jwt = authenticationService.authenticate(authenticationRequest);

    assertEquals(generate_jwt, jwt.getResponse());

  }


}
