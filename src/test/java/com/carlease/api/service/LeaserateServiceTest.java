package com.carlease.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;

import com.carlease.api.entity.Car;
import com.carlease.api.entity.Customer;
import com.carlease.api.mapper.CarMapper;
import com.carlease.api.mapper.LeaseMapper;
import com.carlease.api.model.CarModel;
import com.carlease.api.model.CustomerModel;
import com.carlease.api.model.LeaserateRequest;
import com.carlease.api.model.LeaserateResponse;
import com.carlease.api.repository.CarRepository;
import com.carlease.api.repository.CustomerRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
public class LeaserateServiceTest {

  @Mock
  CarRepository carRepository;

  @InjectMocks
  LeaserateService leaserateService;

  @Test
  public void getLeasRate_forCar_Success() {

    Car car = new Car();
    car.setMake("Honda");;
    car.setModel("CIVIC");;
    car.setVersion("v1");
    car.setGrossPrice(200.0);
    car.setNettPrice(300.00);

    List<Car> listOFCar = Arrays.asList(car);

    lenient().when(carRepository.findByNettPriceLessThanEqual(any())).thenReturn(listOFCar);

    LeaserateRequest leaserateRequest = new LeaserateRequest();
    leaserateRequest.setMileage(BigDecimal.valueOf(100));
    leaserateRequest.setDuration(BigDecimal.valueOf(5.4));
    leaserateRequest.setIntrestRate(BigDecimal.valueOf(5));
    leaserateRequest.setNettPrice(BigDecimal.valueOf(5));

    List<LeaserateResponse> response =leaserateService.getLeaserate(leaserateRequest);
    assertNotNull(response.get(0).getLeaseRate());


  }

}
