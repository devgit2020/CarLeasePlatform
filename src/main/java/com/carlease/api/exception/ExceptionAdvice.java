package com.carlease.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is exception advice class which handles all the exception centrally.
 * it handles the cross cutting concern of exception handling
 *
 * @author Santosh Behera
 * @version 0.1
 */

@ControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(value = Throwable.class)
  public ResponseEntity<Object> exception(Throwable exception) {
    return new ResponseEntity<>("Bad request", HttpStatus.NOT_FOUND);
  }
}