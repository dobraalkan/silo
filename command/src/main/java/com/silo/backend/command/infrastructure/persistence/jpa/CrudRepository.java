package com.silo.backend.command.infrastructure.persistence.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CrudRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {


    default List<T> findAllById(List<ID> anIdList) {
        List ids = StreamSupport.stream(anIdList.spliterator(), false)
                .collect(Collectors.toList());
        return findAllById(ids);
    }
}