
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ComplexityKindRepository;
import com.silo.backend.domain.model.entity.ComplexityKind;
import com.silo.backend.service.ComplexityKindService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link ComplexityKind}.
 * @author
 */
@Service
@Transactional
public class ComplexityKindService {


    private final ComplexityKindRepository repository;

    public ComplexityKindService(ComplexityKindRepository repo) {
         this.repository = repo;
    }

    public ComplexityKind findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<ComplexityKind> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public ComplexityKind create(ComplexityKind d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public ComplexityKind update(ComplexityKind d) {
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

	public Page<ComplexityKind> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<ComplexityKind> findAllSpecification(Specification<ComplexityKind> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
