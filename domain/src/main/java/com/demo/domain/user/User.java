package com.demo.domain.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Getter
@Setter
public class User {
    private String id;
    private String username;
    private String fullName;
    private String password;
}
