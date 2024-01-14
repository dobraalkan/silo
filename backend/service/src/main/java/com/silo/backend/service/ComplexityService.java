
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ComplexityRepository;
import com.silo.backend.domain.model.entity.Complexity;
import com.silo.backend.service.ComplexityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link Complexity}.
 * @author
 */
@Service
@Transactional
public class ComplexityService {


    private final ComplexityRepository repository;

    public ComplexityService(ComplexityRepository repo) {
         this.repository = repo;
    }

    public Complexity findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<Complexity> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public Complexity create(Complexity d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public Complexity update(Complexity d) {
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

	public Page<Complexity> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Complexity> findAllSpecification(Specification<Complexity> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
