package com.carlease.api.service;

import com.carlease.api.entity.Car;
import com.carlease.api.mapper.CarMapper;
import com.carlease.api.mapper.LeaseMapper;
import com.carlease.api.model.CarModel;
import com.carlease.api.model.LeaserateRequest;
import com.carlease.api.model.LeaserateResponse;
import com.carlease.api.repository.CarRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This Service class used for user lease request.
 *
 * @author Santosh Behera
 * @version 0.1
 */

@Service
public class LeaserateService {

  @Autowired
  CarRepository carRepository;

  /***
   * This method generates the leaserate based on the lese parameters
   * @param leaserateRequest object which contains the attribute for lease
   * @return Generates LeaserateResponse as response for customer
   */

  public List<LeaserateResponse> getLeaserate(LeaserateRequest leaserateRequest) {

    List<Car> cars = carRepository.findByNettPriceLessThanEqual(leaserateRequest.getNettPrice());

    List<CarModel> modelCar = CarMapper.INSTANCE.entityToModel(cars);
    List<LeaserateResponse> leaseCar = new ArrayList<>();

    for (CarModel model : modelCar) {
      LeaserateResponse leaserateResponse = LeaseMapper.INSTANCE.copy(leaserateRequest);
      leaserateResponse.setLeaseRate(BigDecimal.valueOf(5.4));
      leaserateResponse.setCar(model);
      leaseCar.add(leaserateResponse);
    }

    return leaseCar;
  }

}
