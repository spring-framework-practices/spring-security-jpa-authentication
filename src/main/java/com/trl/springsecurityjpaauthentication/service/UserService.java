package com.trl.springsecurityjpaauthentication.service;

import com.trl.springsecurityjpaauthentication.controller.dto.UserDTO;

public interface UserService {

    UserDTO getUser(Long id);
}
