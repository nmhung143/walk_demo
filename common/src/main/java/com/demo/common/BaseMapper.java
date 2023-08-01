package com.demo.common;

import org.mapstruct.Mapper;

public interface BaseMapper<E, DM> {
    DM toDomain(E entity);
    E toEntity(DM domain);
}
