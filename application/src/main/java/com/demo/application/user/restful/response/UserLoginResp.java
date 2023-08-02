package com.demo.application.user.restful.response;

import com.demo.domain.user.User;
import com.demo.domain.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResp {
    private UserDto user;
    private String token;
}
