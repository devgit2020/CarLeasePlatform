package com.carlease.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;

import com.carlease.api.entity.Customer;
import com.carlease.api.model.CustomerModel;
import com.carlease.api.repository.CustomerRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest {


  @Mock
  CustomerRepository repositoryMock;

  @InjectMocks
  CustomerService customerService;

  @Test
  public void customer_search_ByCustomerName() {

    Customer customer = new Customer();
    customer.setName("test");

    lenient().when(repositoryMock.findByName(anyString())).thenReturn(Optional.of(customer));

    CustomerModel customerModel = customerService.getCustomer("test");

    assertEquals(customerModel.getName(), "test");

  }

  @Test
  public void saveCustomer_ifNotExist_True() {

    CustomerModel newCustomer = new CustomerModel();
    newCustomer.setName("test");

    Customer savedCust = new Customer();
    savedCust.setName("test");
    savedCust.setId(100);

    lenient().when(repositoryMock.save(any())).thenReturn(savedCust);

    //CustomerMapper.INSTANCE.DtoToModel(customer);
    customerService.saveCutomer(newCustomer);

    assertEquals(customerService.saveCutomer(newCustomer), 100);

  }

  /***
   * This method update the existing customer if present instead save
   *
   */

  @Test
  public void updateCustomer_ifExist_True() {

    CustomerModel existing = new CustomerModel();
    existing.setName("test");

    Customer updateCustomer = new Customer();
    updateCustomer.setName("test");
    updateCustomer.setId(200);

    lenient().when(repositoryMock.findByName(anyString())).thenReturn(Optional.of(updateCustomer));

    lenient().when(repositoryMock.save(any())).thenReturn(updateCustomer);

    customerService.saveCutomer(existing);

    assertEquals(customerService.saveCutomer(existing), 200);

  }


}
