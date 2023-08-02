package com.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;

/**
 * @author : hung.nguyenmanh
 * @created : 8/2/2023
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private List<T> data;
    private Integer pageIndex;
    private Integer pageSize;
    private Long totalElement;
    private Integer totalPage;

    public Page(org.springframework.data.domain.Page<T> springPage) {
        this.data = springPage.getContent();
        this.pageIndex = springPage.getPageable().getPageNumber();
        this.pageSize = springPage.getPageable().getPageSize();
        this.totalElement = springPage.getTotalElements();
        this.totalPage = springPage.getTotalPages();
    }
}
