
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ApplicationGroupEntryRepository;
import com.silo.backend.domain.model.entity.ApplicationGroupEntry;
import com.silo.backend.service.ApplicationGroupEntryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link ApplicationGroupEntry}.
 * @author
 */
@Service
@Transactional
public class ApplicationGroupEntryService {


    private final ApplicationGroupEntryRepository repository;

    public ApplicationGroupEntryService(ApplicationGroupEntryRepository repo) {
         this.repository = repo;
    }

    public ApplicationGroupEntry findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<ApplicationGroupEntry> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public ApplicationGroupEntry create(ApplicationGroupEntry d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public ApplicationGroupEntry update(ApplicationGroupEntry d) {
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

	public Page<ApplicationGroupEntry> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<ApplicationGroupEntry> findAllSpecification(Specification<ApplicationGroupEntry> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
