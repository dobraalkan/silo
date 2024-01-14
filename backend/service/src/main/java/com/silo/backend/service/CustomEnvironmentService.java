
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.CustomEnvironmentRepository;
import com.silo.backend.domain.model.entity.CustomEnvironment;
import com.silo.backend.service.CustomEnvironmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link CustomEnvironment}.
 * @author
 */
@Service
@Transactional
public class CustomEnvironmentService {


    private final CustomEnvironmentRepository repository;

    public CustomEnvironmentService(CustomEnvironmentRepository repo) {
         this.repository = repo;
    }

    public CustomEnvironment findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<CustomEnvironment> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public CustomEnvironment create(CustomEnvironment d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public CustomEnvironment update(CustomEnvironment d) {
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

	public Page<CustomEnvironment> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<CustomEnvironment> findAllSpecification(Specification<CustomEnvironment> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
