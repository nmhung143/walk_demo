package com.demo.common;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
public abstract class BaseApplicationService<DM, ID, R extends BasePersistence<DM, ID>> implements BaseUseCase<DM, ID> {
    protected final R repo;

    public BaseApplicationService(R repo) {
        this.repo = repo;
    }
    @Override
    public DM save(DM domain) {
        return repo.save(domain);
    }

    @Override
    public DM findById(ID id) {
        return repo.findById(id);
    }

    @Override
    public Optional<DM> findByIdOpt(ID id) {
        return repo.findByIdOpt(id);
    }

    @Override
    public void delete(ID id) {
        repo.delete(id);
    }
}
