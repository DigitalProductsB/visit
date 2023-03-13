package com.internal.visit.controller

import com.internal.visit.model.User
import com.internal.visit.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE)
class LoginController {

    @Autowired
    UserService userService

    @PostMapping("/signin")
    ResponseEntity<Map<String, String>> authenticateUser(@RequestBody User user) {
        if(userService.authenticate(user)){
            return new ResponseEntity<>(["status": "Success", "message": "User Signed in successfully!"], HttpStatus.OK)
        }
        return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED)
    }
}
