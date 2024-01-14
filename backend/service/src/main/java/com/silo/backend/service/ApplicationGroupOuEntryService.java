
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ApplicationGroupOuEntryRepository;
import com.silo.backend.domain.model.entity.ApplicationGroupOuEntry;
import com.silo.backend.service.ApplicationGroupOuEntryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link ApplicationGroupOuEntry}.
 * @author
 */
@Service
@Transactional
public class ApplicationGroupOuEntryService {


    private final ApplicationGroupOuEntryRepository repository;

    public ApplicationGroupOuEntryService(ApplicationGroupOuEntryRepository repo) {
         this.repository = repo;
    }

    public ApplicationGroupOuEntry findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<ApplicationGroupOuEntry> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public ApplicationGroupOuEntry create(ApplicationGroupOuEntry d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public ApplicationGroupOuEntry update(ApplicationGroupOuEntry d) {
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

	public Page<ApplicationGroupOuEntry> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<ApplicationGroupOuEntry> findAllSpecification(Specification<ApplicationGroupOuEntry> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
