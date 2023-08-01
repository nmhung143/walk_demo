package com.demo.infrastructure.persistence.adapter;

import com.demo.common.BaseAdapter;
import com.demo.common.exception.ErrorCode;
import com.demo.domain.user.User;
import com.demo.domain.user.persistence.UserPersistence;
import com.demo.infrastructure.persistence.mapper.UserEntityMapper;
import com.demo.infrastructure.persistence.mongo.entity.UserEntity;
import com.demo.infrastructure.persistence.mongo.repo.UserEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceAdapter extends BaseAdapter<UserEntity, User, String> implements UserPersistence {
    protected UserPersistenceAdapter(UserEntityMapper mapper,
                                     UserEntityRepository repo) {
        super(mapper, repo);
    }

    @Override
    protected ErrorCode NotFoundErrorCode() {
        return ErrorCode.NOT_FOUND_USER;
    }
}
