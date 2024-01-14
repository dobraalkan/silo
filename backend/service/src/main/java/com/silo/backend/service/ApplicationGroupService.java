
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ApplicationGroupRepository;
import com.silo.backend.domain.model.entity.ApplicationGroup;
import com.silo.backend.service.ApplicationGroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link ApplicationGroup}.
 * @author
 */
@Service
@Transactional
public class ApplicationGroupService {


    private final ApplicationGroupRepository repository;

    public ApplicationGroupService(ApplicationGroupRepository repo) {
         this.repository = repo;
    }

    public ApplicationGroup findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<ApplicationGroup> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public ApplicationGroup create(ApplicationGroup d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public ApplicationGroup update(ApplicationGroup d) {
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

	public Page<ApplicationGroup> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<ApplicationGroup> findAllSpecification(Specification<ApplicationGroup> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
