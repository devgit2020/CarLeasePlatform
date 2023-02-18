package com.carlease.api.service;

import com.carlease.api.entity.Customer;
import com.carlease.api.mapper.CustomerMapper;
import com.carlease.api.model.CustomerModel;
import com.carlease.api.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This Service class used for user Customer functionality.
 * @author Santosh Behera
 * @version 0.1
 */

@Service
public class CustomerService {

  @Autowired
  CustomerRepository repository;

  /**
   * This method returns an existing customer information
   * @param customerName - client passed parameter as customer name
   * @return CustomerModel - return a customer model which stores customer information
   */
  public CustomerModel getCustomer(String customerName) {
    CustomerModel customer = CustomerMapper.INSTANCE
        .modelToDto(repository.findByName(customerName).get());
    return customer;
  }

  /**
   * This method stores or save a new customer or update  customer information,if present
   * @param customer - it store new customer information which not yet present
   * @return void -
   */

  public Integer saveCutomer(CustomerModel customer) {

    Customer newCustomer = CustomerMapper.INSTANCE.DtoToModel(customer);
    Optional<com.carlease.api.entity.Customer> optCustomer = repository.findByName(customer.getName());
    if (optCustomer.isPresent()) {
      newCustomer.setId(optCustomer.get().getId());
    }

    return repository.save(newCustomer).getId();
  }
  /**
   * This method deletes the customer from the table
   * @param customerName - takes the parameter as customername to delete
   * @return void -
   */

  @Transactional
  public void deleteCutomer(String customerName) {
    repository.deleteByName(customerName);

  }

}
