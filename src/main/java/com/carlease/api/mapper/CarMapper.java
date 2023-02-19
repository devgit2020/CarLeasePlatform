package com.carlease.api.mapper;


import com.carlease.api.entity.Car;
import com.carlease.api.model.CarModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/***
 * This is mapper class from mapstruct framework to copy the value from entity to model class and vice versa
 *
 * @author Santosh Behera
 * @version 0.1
 *
 */
@Mapper
public interface CarMapper {

  /**
   * create instance of mapper class
   */
  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  /**
   * This method copy the car model class to Car entity
   * @param carModel
   * @return
   */

  Car modelToEntity(CarModel carModel);


  /**
   * This method copy the list of car entity class to  list of Car model class
   * @param carModel - list of car entity class
   * @return list of car model
   */
  List<CarModel> entityToModel(List<Car> carModel);



}
