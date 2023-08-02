package com.demo.infrastructure.persistence.mapper;

import com.demo.common.BaseMapper;
import com.demo.domain.user.User;
import com.demo.infrastructure.persistence.mongo.entity.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Mapper
public interface UserEntityMapper extends BaseMapper<UserEntity, User> {
}
