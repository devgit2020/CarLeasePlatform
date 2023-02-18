package com.carlease.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * This is Customer entity class used to store Customer data
 *
 * @author Santosh Behera
 * @version 0.1
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private String street;
  private String houseNumber;
  private String zipcode;
  private String place;
  private String email;
  private Integer phone;
  private String password;

}
