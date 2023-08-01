package com.demo.common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseApplicationService<DM, ID, R extends BasePersistence<DM, ID>> implements BaseUseCase<DM, ID> {
    private final R repo;
    @Override
    public DM save(DM domain) {
        return repo.save(domain);
    }

    @Override
    public DM findById(ID id) {
        return repo.findById(id);
    }

    @Override
    public void delete(ID id) {
        repo.delete(id);
    }
}
