package com.carlease.api.mapper;

import com.carlease.api.model.CustomerModel;
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
public interface CustomerMapper {

  /**
   * create instance of mapper class
   */
  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  /**
   * This method copy the value form Customer entity class to Customer model class
   * @param customer - create customer model class from input of customer entity input
   * @return customer model class
   */

  CustomerModel modelToDto(com.carlease.api.entity.Customer customer);

  /**
   * This method copy the value form Customer model class to Customer entity class
   * @param customerModel - create customer entity class from input of customer model input
   * @return customer entity class
   */

  com.carlease.api.entity.Customer DtoToModel(CustomerModel customerModel);

}
