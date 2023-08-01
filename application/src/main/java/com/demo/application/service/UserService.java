package com.demo.application.service;

import com.demo.common.BaseApplicationService;
import com.demo.domain.user.User;
import com.demo.domain.user.persistence.UserPersistence;
import org.springframework.stereotype.Component;

@Component
public class UserService extends BaseApplicationService<User, String, UserPersistence> {
    public UserService(UserPersistence repo) {
        super(repo);
    }
}
