package com.demo.common;

import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public interface BasePersistence<DM, ID> {
    DM save(DM domain);
    DM findById(ID id);
    public Optional<DM> findByIdOpt(ID id);
    void delete(ID id);
}
