package com.trl.springsecurityjpaauthentication.tmp;

import com.trl.springsecurityjpaauthentication.repository.UserRepository;
import com.trl.springsecurityjpaauthentication.repository.entity.UserEntity;
import com.trl.springsecurityjpaauthentication.service.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("Tsyupryk");
        userEntity.setLastName("Roman");
        userEntity.setUserName("TRL");
        userEntity.setEmail("tsyupryk.roman@gmail.com");
        userEntity.setPassword("pass");
        userEntity.setAccountNonExpired(true);
        userEntity.setAccountNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnabled(true);
        userEntity.setAuthorities(Set.of(UserRole.ADMIN));

        repository.save(userEntity);

    }
}
