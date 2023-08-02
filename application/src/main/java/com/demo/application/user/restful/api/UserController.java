package com.demo.application.user.restful.api;

import com.demo.application.user.facade.UserFacade;
import com.demo.application.user.restful.request.CreateUserReq;
import com.demo.application.user.restful.request.UserLoginReq;
import com.demo.application.user.restful.response.UserLoginResp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {
    private final UserFacade userFacade;

    //    public UserController(UserFacade userFacade) {
//        this.userFacade = userFacade;
//    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateUserReq req) {
        userFacade.create(req);
    }

    @PostMapping("/login")
    public UserLoginResp login(@RequestBody UserLoginReq req) {
        return userFacade.login(req);
    }
}
