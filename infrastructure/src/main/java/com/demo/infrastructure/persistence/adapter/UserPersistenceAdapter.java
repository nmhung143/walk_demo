package com.demo.infrastructure.persistence.adapter;

import com.demo.common.BaseAdapter;
import com.demo.common.BaseMapper;
import com.demo.common.exception.ErrorCode;
import com.demo.common.exception.WalkException;
import com.demo.domain.user.User;
import com.demo.domain.user.persistence.UserPersistence;
import com.demo.infrastructure.persistence.mapper.UserEntityMapper;
import com.demo.infrastructure.persistence.mongo.entity.UserEntity;
import com.demo.infrastructure.persistence.mongo.repo.UserEntityRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Component
@SuppressWarnings("ALL")
public class UserPersistenceAdapter extends BaseAdapter<UserEntity, User, String> implements UserPersistence {
    protected UserPersistenceAdapter(UserEntityMapper mapper,
                                     UserEntityRepository repo) {
        super(mapper, repo);
    }

    @Override
    protected ErrorCode notFoundErrorCode() {
        return ErrorCode.NOT_FOUND_USER;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        var userOpt = repo().findUserEntityByUsername(username);
        return Optional.ofNullable(mapper.toDomain(userOpt.get()));
    }


    @Override
    protected UserEntityMapper mapper() {
        return (UserEntityMapper) mapper;
    }

    @Override
    protected UserEntityRepository repo() {
        return (UserEntityRepository) repo;
    }
}
