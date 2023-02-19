package com.carlease.api.mapper;

import com.carlease.api.model.LeaserateRequest;
import com.carlease.api.model.LeaserateResponse;
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
public interface LeaseMapper {

  /**
   * create instance of mapper class
   */
  LeaseMapper INSTANCE = Mappers.getMapper(LeaseMapper.class);

  /***
   *
   * @param leaserateRequest- takes leaserateRequest request and convert to another model type
   * @return
   */
  LeaserateResponse copy(LeaserateRequest leaserateRequest);

}
