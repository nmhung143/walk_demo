package com.demo.common;

import org.mapstruct.Mapper;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public interface BaseMapper<E, DM> {
    DM toDomain(E entity);
    E toEntity(DM domain);
}
