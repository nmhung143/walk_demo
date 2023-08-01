package com.demo.common;

public interface BasePersistence<DM, ID> {
    DM save(DM domain);
    DM findById(ID id);
    void delete(ID id);
}
