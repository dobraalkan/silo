
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ApplicationComponentRepository;
import com.silo.backend.domain.model.entity.ApplicationComponent;
import com.silo.backend.service.ApplicationComponentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link ApplicationComponent}.
 * @author
 */
@Service
@Transactional
public class ApplicationComponentService {


    private final ApplicationComponentRepository repository;

    public ApplicationComponentService(ApplicationComponentRepository repo) {
         this.repository = repo;
    }

    public ApplicationComponent findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<ApplicationComponent> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public ApplicationComponent create(ApplicationComponent d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public ApplicationComponent update(ApplicationComponent d) {
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

	public Page<ApplicationComponent> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<ApplicationComponent> findAllSpecification(Specification<ApplicationComponent> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
