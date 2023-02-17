package com.carlease.api.config;

import com.carlease.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This configuration class is used to configure and intialize the security configuration object
 *
 * @author Santosh Behera
 * @version 0.1
 */

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserRepository repository;

  /**
   * This method overrides UserDetailService of Security default behaviour.
   * It uses custom JPA repository to retrieve the user inforamtion from user table.
   * @return
   */
  @Bean
  public UserDetailsService userDetailsService() {
    return username -> repository.findByUserName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  /**
   * This method intialize the Authenticate provider of spring security framework to overide the default daoAthenticateprovider.
   * The DaoAuthentication provider use the custom user service provider
   *
   */
  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
      throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
