package com.carlease.api.repository;

import com.carlease.api.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * This repository used for User entity related functionality
 *
 * @author Santosh Behera
 * @version 0.1
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

  /**
   * It search a existing user from table
   * @param userName - take a username to find the existing user from table
   * @return it return a user entity which holds user information,if it present
   */
  Optional<User> findByUserName(String userName);

  /**
   * It delete a user from the table
   * @param userName - take a username to delete user from table
   * @return
   */
  void deleteByUserName(String userName);


}
