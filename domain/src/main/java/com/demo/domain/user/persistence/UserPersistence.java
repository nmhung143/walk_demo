package com.demo.domain.user.persistence;

import com.demo.common.BasePersistence;
import com.demo.domain.user.User;

import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public interface UserPersistence extends BasePersistence<User, String> {
    Optional<User> findByUsername(String username);
}
