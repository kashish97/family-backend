package com.family.authentication.controller;

import com.family.FamilyCoreException;
import com.family.ServiceResponse;
import com.family.authentication.request.RegisterUserRequest;
import com.family.authentication.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/family/authenticate")
public class AuthenticationController {

    @Autowired
    AuthenticationService authService;

    @RequestMapping(value = "/{phone}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResponse<String>> getUserDetailsFromPhone(@PathVariable("phone") String phone) throws FamilyCoreException {
        ServiceResponse<String> response = new ServiceResponse<String>(authService.getUserFromPhone(phone),
                null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<ServiceResponse<String>> registerUser(@RequestBody RegisterUserRequest registerUserRequest) throws FamilyCoreException {
        ServiceResponse<String> response = new ServiceResponse<String>(authService.registerUser(registerUserRequest),
                null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}