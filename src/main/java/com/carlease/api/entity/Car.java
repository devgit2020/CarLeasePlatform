package com.carlease.api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * This is Car entity class used to store Car data
 *
 * @author Santosh Behera
 * @version 0.1
 */

@Getter
@Setter
@Entity
@Table(name="car")
public class Car implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;
  private String make;
  private String model;
  private String version;
  private Integer noOfDoors;
  private String c02Emission;
  private Double grossPrice;
  private Double nettPrice;


}
