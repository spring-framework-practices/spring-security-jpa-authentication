package com.trl.springsecurityjpaauthentication.controller;

import com.trl.springsecurityjpaauthentication.controller.dto.UserDTO;
import com.trl.springsecurityjpaauthentication.service.UserService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        ResponseEntity<UserDTO> response = null;

        UserDTO resultService = userService.getUser(id);

        response = ResponseEntity.ok(resultService);

        return response;
    }
}
