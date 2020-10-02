package com.family.user.controller;

import com.family.FamilyCoreException;
import com.family.ServiceResponse;
import com.family.user.domain.User;
import com.family.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/family/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResponse<User>> getUserDetailsFromPhone(@PathVariable("userId") String userId) throws FamilyCoreException {
        ServiceResponse<User> response = new ServiceResponse<User>(userService.getUser(userId),
                null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
