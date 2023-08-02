package com.demo.application.user.mapper;

import com.demo.application.user.restful.request.CreateUserReq;
import com.demo.domain.user.User;
import com.demo.domain.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.lang.annotation.Target;

@Mapper
public interface UserMapper {
    @Mapping(target = "password", source = "password")
    User toDomain(CreateUserReq req, String password);

    UserDto toDto(User user);
}
