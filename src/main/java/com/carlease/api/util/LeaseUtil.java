package com.carlease.api.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class LeaseUtil {

  public static BigDecimal leaseCal(BigDecimal mileage,BigDecimal duration,BigDecimal interestRate,BigDecimal nettPrice){
      return toPrecision((((mileage.doubleValue()/12)*duration.doubleValue())/nettPrice.doubleValue())+((interestRate.doubleValue()/100)*nettPrice.doubleValue()/12));
  }

  private static BigDecimal toPrecision(Double value) {
        return BigDecimal.valueOf(Math.round((value*100.0)/100.0));
  }

}
