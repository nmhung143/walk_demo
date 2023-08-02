package com.demo.domain.user.usecase;

import com.demo.common.BaseUseCase;
import com.demo.domain.user.User;

import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public interface UserUseCase extends BaseUseCase<User, String> {
    Optional<User> findByUsername(String username);
}
