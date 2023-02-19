package com.carlease.api.repository;

import com.carlease.api.entity.Car;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/***
 * This repository used for Car entity related functionality
 *
 * @author Santosh Behera
 * @version 0.1
 *
 */

public interface CarRepository extends CrudRepository<Car, Integer> {

  /**
   * It search a existing car from table
   * @param make - take a make to find the existing car from table
   * @return it return list of cars entity which if it is present
   */
  List<Car> getCarByMake(String make);

  /**
   * It search a existing car from table based on the netprice
   * @param netPrice - search car entity based on the netprice
   * @return it return list of cars entity which if it is present
   */

  List<Car> findByNettPriceLessThanEqual(BigDecimal netPrice);


}
