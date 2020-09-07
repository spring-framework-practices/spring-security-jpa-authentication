package com.trl.springsecurityjpaauthentication.service.impl;

import com.trl.springsecurityjpaauthentication.controller.dto.UserDTO;
import com.trl.springsecurityjpaauthentication.repository.UserRepository;
import com.trl.springsecurityjpaauthentication.repository.entity.UserEntity;
import com.trl.springsecurityjpaauthentication.service.UserService;
import com.trl.springsecurityjpaauthentication.service.converter.UserConverter;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO getUser(Long id) {
        UserDTO resultUser = null;

        Optional<UserEntity> userFromRepository = repository.findById(id);

        if (userFromRepository.isPresent()) {
            resultUser = UserConverter.mapEntityToDTO(userFromRepository.get());
        }

        return resultUser;
    }
}
