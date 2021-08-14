package com.g3tecnologia.crud.core.presentation.controllers.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public ResponseEntity<?> Ok (Object object){
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    public ResponseEntity<?> BadRequest (Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
