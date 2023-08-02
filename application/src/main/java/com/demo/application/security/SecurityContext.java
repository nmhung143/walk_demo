package com.demo.application.security;

import com.demo.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Component
public class SecurityContext {
    public User getUserLogin() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public String username() {
        return getUserLogin().getUsername();
    }

    public String getUserId() {
        return getUserLogin().getId();
    }

    public String getFullName() {
        return getUserLogin().getFullName();
    }
}
