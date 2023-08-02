package com.demo.application.user.service;

import com.demo.common.BaseApplicationService;
import com.demo.domain.user.User;
import com.demo.domain.user.persistence.UserPersistence;
import com.demo.domain.user.usecase.UserUseCase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BaseApplicationService<User, String, UserPersistence> implements UserUseCase {
    public UserService(UserPersistence repo) {
        super(repo);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }
}
