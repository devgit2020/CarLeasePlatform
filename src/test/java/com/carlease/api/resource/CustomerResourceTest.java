package com.carlease.api.resource;

import static com.carlease.api.resource.UserResourceTest.asJsonString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.carlease.api.config.JwtAuthenticationFilter;
import com.carlease.api.config.JwtService;
import com.carlease.api.entity.Customer;
import com.carlease.api.entity.User;
import com.carlease.api.model.CustomerModel;
import com.carlease.api.model.RegisterUserRequest;
import com.carlease.api.repository.CustomerRepository;
import com.carlease.api.repository.UserRepository;
import com.carlease.api.service.AuthenticationService;
import com.carlease.api.service.CustomerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@AutoConfigureMockMvc
@SpringBootTest
public class CustomerResourceTest {

 @Autowired
 AuthenticationService authenticationService;

  @Autowired
  JwtService jwtService;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void intializeTestUser(){
    RegisterUserRequest userDummy = new RegisterUserRequest();
    userDummy.setUserName("test");
    userDummy.setPassword("test123");
    userDummy.setEmail("test@test.com");
    authenticationService.register(userDummy);

  }
  @Test
  public void createCustomer_ifNotExist_ResultTrue() throws Exception {

    User userDummy = new User();
    userDummy.setUserName("test");
    userDummy.setPassword("test123");

    Optional<User> userOptional = Optional.of(userDummy);

    CustomerModel customerModel = new CustomerModel();
    customerModel.setName("test");
    customerModel.setEmail("santosh.behera@ing.com");

    Customer customer = new Customer();
    customer.setId(100);



    mockMvc.perform(MockMvcRequestBuilders
        .post("/api/v1/customer/create")
        .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtService.generateToken(userDummy))
        .content(asJsonString(customerModel))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful());

  }


}
