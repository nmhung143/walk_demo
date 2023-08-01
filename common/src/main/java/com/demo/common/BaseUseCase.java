package com.demo.common;

public interface BaseUseCase<DM, ID> {
    DM save(DM domain);
    DM findById(ID id);
    void delete(ID id);
}
