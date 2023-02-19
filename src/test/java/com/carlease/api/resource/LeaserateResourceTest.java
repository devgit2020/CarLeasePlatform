package com.carlease.api.resource;

import static com.carlease.api.resource.UserResourceTest.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.carlease.api.config.JwtService;
import com.carlease.api.entity.User;
import com.carlease.api.model.AuthenticationRequest;
import com.carlease.api.model.CustomerModel;
import com.carlease.api.model.LeaserateRequest;
import com.carlease.api.model.RegisterUserRequest;
import com.carlease.api.service.AuthenticationService;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
public class LeaserateResourceTest {


  @Autowired
  AuthenticationService authenticationService;

  @Autowired
  JwtService jwtService;

  String jwttoken = "Bearer ";
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void intializeTestUser() {
    RegisterUserRequest userDummy = new RegisterUserRequest();
    userDummy.setUserName("test");
    userDummy.setPassword("test123");
    userDummy.setEmail("test@test.com");
    authenticationService.register(userDummy);

    User testuser = new User();
    testuser.setUserName("test");
    testuser.setPassword("test123");
    jwttoken += jwtService.generateToken(testuser);

  }

  @Test
  public void getLeasRate_Success() throws Exception {

    LeaserateRequest leaserateRequest = new LeaserateRequest();
    leaserateRequest.setMileage(BigDecimal.valueOf(100));
    leaserateRequest.setDuration(BigDecimal.valueOf(5.4));
    leaserateRequest.setIntrestRate(BigDecimal.valueOf(5));
    leaserateRequest.setNettPrice(BigDecimal.valueOf(5));

    mockMvc.perform(MockMvcRequestBuilders
        .post("/api/v1/lease/lease-rate")
        .header(HttpHeaders.AUTHORIZATION, jwttoken)
        .content(asJsonString(leaserateRequest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful());

  }

  @AfterEach
  public void destroy() {

    AuthenticationRequest userDummy = new AuthenticationRequest();
    userDummy.setUserName("test");
    authenticationService.deleteUser(userDummy);
  }
}