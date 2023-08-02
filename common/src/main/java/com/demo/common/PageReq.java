package com.demo.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Getter
@Setter
public class PageReq {
    private Integer pageIndex = 0; //default value
    private Integer pageSize = 20;
}
