package com.demo.application.user.facade;

import com.demo.application.security.UserRepoDetails;
import com.demo.application.user.mapper.UserMapper;
import com.demo.application.user.restful.request.CreateUserReq;
import com.demo.application.user.restful.request.UserLoginReq;
import com.demo.application.user.restful.response.UserLoginResp;
import com.demo.application.utils.JwtUtils;
import com.demo.domain.user.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserUseCase userUseCase;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public void create(CreateUserReq req) {
        var user = userMapper.toDomain(req, passwordEncoder.encode(req.getPassword()));
        userUseCase.save(user);
    }

    public UserLoginResp login(UserLoginReq req) {
        var basicAuth = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        var authentication = authenticationManager.authenticate(basicAuth);
        var userDetails = (UserRepoDetails) authentication.getPrincipal();
        return new UserLoginResp(
                userMapper.toDto(userDetails.getUser()),
                jwtUtils.generate(authentication));
    }


}
