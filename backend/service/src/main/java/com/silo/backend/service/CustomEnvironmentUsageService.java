
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.CustomEnvironmentUsageRepository;
import com.silo.backend.domain.model.entity.CustomEnvironmentUsage;
import com.silo.backend.service.CustomEnvironmentUsageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link CustomEnvironmentUsage}.
 * @author
 */
@Service
@Transactional
public class CustomEnvironmentUsageService {


    private final CustomEnvironmentUsageRepository repository;

    public CustomEnvironmentUsageService(CustomEnvironmentUsageRepository repo) {
         this.repository = repo;
    }

    public CustomEnvironmentUsage findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<CustomEnvironmentUsage> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public CustomEnvironmentUsage create(CustomEnvironmentUsage d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public CustomEnvironmentUsage update(CustomEnvironmentUsage d) {
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

	public Page<CustomEnvironmentUsage> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<CustomEnvironmentUsage> findAllSpecification(Specification<CustomEnvironmentUsage> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
