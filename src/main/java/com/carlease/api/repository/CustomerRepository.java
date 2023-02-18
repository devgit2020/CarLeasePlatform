package com.carlease.api.repository;

import com.carlease.api.entity.Customer;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/***
 * This repository used for Customer entity related functionality
 *
 * @author Santosh Behera
 * @version 0.1
 *
 */

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  /**
   * It search a existing customer from table
   * @param name - take a name to find the existing customer from table
   * @return it return a user entity which holds customer information,if it present
   */
  Optional<Customer> findByName(String name);

  /**
   * It delete a customer from the table
   * @param name - take a customer to delete customer from table
   * @return
   */
  void deleteByName(String name);




}
