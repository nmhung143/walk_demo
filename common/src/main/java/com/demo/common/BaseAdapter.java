package com.demo.common;

import com.demo.common.exception.ErrorCode;
import com.demo.common.exception.WalkException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@SuppressWarnings("ALL")
public abstract class BaseAdapter<E, DM, ID> implements BasePersistence<DM, ID> {
    protected BaseMapper<E, DM> mapper;
    protected MongoRepository<E, ID> repo;

    protected BaseAdapter(BaseMapper<E, DM> mapper, MongoRepository<E, ID> repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public DM save(DM domain) {
        var entity = mapper.toEntity(domain);
        return mapper.toDomain(repo.save(entity));
    }

    @Override
    public DM findById(ID id) {
        var entity = repo.findById(id);
        if (entity.isEmpty()) {
            throw new WalkException(notFoundErrorCode());
        }
        return mapper.toDomain(entity.get());
    }

    @Override
    public Optional<DM> findByIdOpt(ID id) {
        var entity = repo.findById(id);
        return Optional.ofNullable(mapper.toDomain(entity.get()));
    }

    @Override
    public void delete(ID id) {
        repo.deleteById(id);
    }

    protected abstract ErrorCode notFoundErrorCode();

    protected BaseMapper mapper() {
        return mapper;
    }

    protected MongoRepository repo() {
        return repo;
    }
}
