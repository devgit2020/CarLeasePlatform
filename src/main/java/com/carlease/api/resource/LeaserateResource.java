package com.carlease.api.resource;

import com.carlease.api.model.LeaserateRequest;
import com.carlease.api.model.LeaserateResponse;
import com.carlease.api.service.LeaserateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 * This resource class serves the endpoint for lease related functionality
 *
 * @author Santosh Behera
 * @version 0.1
 *
 */

@RestController
@RequestMapping("/api/v1/lease")
public class LeaserateResource {

  @Autowired
  LeaserateService leaserateService;

  /**
   * This endpoint is for create a lease rate based on the lease information
   * @param lease - holds the lease query parameter which helps to generate a lease rate
   * @return  leaserateResponse - it return information about the lease rate based on the model
   */

  @RequestMapping(value = "/lease-rate", method = RequestMethod.POST)
  public ResponseEntity<List<LeaserateResponse>> getLease(@RequestBody LeaserateRequest lease) {

    return ResponseEntity.ok(leaserateService.getLeaserate(lease));
  }

}
