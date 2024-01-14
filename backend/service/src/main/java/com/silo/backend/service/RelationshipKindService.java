
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.RelationshipKindRepository;
import com.silo.backend.domain.model.entity.RelationshipKind;
import com.silo.backend.service.RelationshipKindService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link RelationshipKind}.
 * @author
 */
@Service
@Transactional
public class RelationshipKindService {


    private final RelationshipKindRepository repository;

    public RelationshipKindService(RelationshipKindRepository repo) {
         this.repository = repo;
    }

    public RelationshipKind findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<RelationshipKind> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public RelationshipKind create(RelationshipKind d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public RelationshipKind update(RelationshipKind d) {
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

	public Page<RelationshipKind> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<RelationshipKind> findAllSpecification(Specification<RelationshipKind> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
