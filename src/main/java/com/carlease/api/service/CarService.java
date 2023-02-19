package com.carlease.api.service;

import com.carlease.api.entity.Car;
import com.carlease.api.mapper.CarMapper;
import com.carlease.api.model.CarModel;
import com.carlease.api.repository.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This Service class used for user car service  like add a new card and retrieve a car
 * information.
 *
 * @author Santosh Behera
 * @version 0.1
 */

@Service
public class CarService {

  @Autowired
  CarRepository repository;


  /**
   * This methods save a new car information to the system.
   *
   * @param cars - it holds a new car information
   * @return void
   */
  public void saveCars(CarModel cars) {

    Car newCars = CarMapper.INSTANCE.modelToEntity(cars);
    repository.save(newCars);
  }

  /**
   * This method return a car information based on the make
   *
   * @param make - this parameter holds the information about the make type
   * @return void
   */
  public List<CarModel> getCarByMake(String make) {
    List<Car> cars = repository.getCarByMake(make);
    List<CarModel> modelCar = CarMapper.INSTANCE.entityToModel(cars);
    return modelCar;

  }
}
