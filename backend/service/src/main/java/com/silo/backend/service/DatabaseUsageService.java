
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.DatabaseUsageRepository;
import com.silo.backend.domain.model.entity.DatabaseUsage;
import com.silo.backend.service.DatabaseUsageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link DatabaseUsage}.
 * @author
 */
@Service
@Transactional
public class DatabaseUsageService {


    private final DatabaseUsageRepository repository;

    public DatabaseUsageService(DatabaseUsageRepository repo) {
         this.repository = repo;
    }

    public DatabaseUsage findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<DatabaseUsage> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public DatabaseUsage create(DatabaseUsage d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public DatabaseUsage update(DatabaseUsage d) {
        try {
            return repository.saveAndFlush(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public long count() {
        try {
            return repository.count();
        } catch (Exception ex) {
            return 0;
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

	public Page<DatabaseUsage> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<DatabaseUsage> findAllSpecification(Specification<DatabaseUsage> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
