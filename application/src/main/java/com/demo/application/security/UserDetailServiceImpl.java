package com.demo.application.security;

import com.demo.domain.user.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserUseCase userUseCase;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userUseCase.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserRepoDetails(user.get());
    }

}
