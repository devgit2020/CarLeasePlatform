package com.carlease.api.resource;

import com.carlease.api.model.CarModel;
import com.carlease.api.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/***
 * This resource class serves the endpoint for car  related functionality
 *
 * @author Santosh Behera
 * @version 0.1
 *
 */
@RestController
@RequestMapping("/api/v1/car")
public class CarResource {

  @Autowired
  CarService carService;

  /**
   * This endpoint  used for save a new car information to the system
   * @param cars - it holds the new car information
   * @return returns status message if it saved or not
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ResponseEntity<String> saveNewCar(@RequestBody CarModel cars) {
    carService.saveCars(cars);
    return ResponseEntity.ok("Cars  saved..");
  }

  /**
   * This endpoint used for retrieve a car information based on the make type
   * @param make - it holds information about the make
   * @return CarModel - it holds the search car information.
   */
  @RequestMapping(value = "/make", method = RequestMethod.GET)
  public ResponseEntity<List<CarModel>> getCarByMake(@RequestParam("make") String make) {

    return ResponseEntity.ok(carService.getCarByMake(make));
  }
}
