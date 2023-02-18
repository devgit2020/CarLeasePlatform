package com.carlease.api.resource;

import com.carlease.api.model.CustomerModel;
import com.carlease.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * This resource class serves the endpoint for customer related functionality
 *
 * @author Santosh Behera
 * @version 0.1
 *
 */

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerResource {

  @Autowired
  CustomerService customerService;

  /**
   * This method crates a new customer in the applicaiton
   * @param customer - it holds the new customer information
   * @return status of the new customer created
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<String> createCustomer(@RequestBody CustomerModel customer) {
    customerService.saveCutomer(customer);
    return ResponseEntity.ok("New Customer saved..");
  }

  /**
   * This method update the existing customer information
   * @param customer - it holds the update information about the customer
   * @return status of the update customer created
   */

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ResponseEntity<String> updateCustomer(@RequestBody CustomerModel customer) {
    customerService.saveCutomer(customer);
    return ResponseEntity.ok("Customer record updated..");
  }

  /**
   * This method retrieves the existing customer information
   * @param customerName - it holds the customername to retrieve from the system
   * @return CustomerModel - returns the existing customer information from the system
   */

  @RequestMapping(value = "/customer", method = RequestMethod.GET)
  public ResponseEntity<CustomerModel> getCustomerByName(
      @RequestParam("customer") String customerName) {
    return ResponseEntity.ok(customerService.getCustomer(customerName));
  }

  /**
   * This method delete the existing customer information
   * @param customerName - it holds the custome rname to delete from the system
   * @return Status - returns the delete status
   */

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public ResponseEntity<String> deleteCustomer(@RequestParam("customer") String customerName) {
    customerService.deleteCutomer(customerName);
    return ResponseEntity.ok("Customer record deleted..");
  }


}
