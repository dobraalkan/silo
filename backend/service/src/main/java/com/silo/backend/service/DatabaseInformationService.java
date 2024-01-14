
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.DatabaseInformationRepository;
import com.silo.backend.domain.model.entity.DatabaseInformation;
import com.silo.backend.service.DatabaseInformationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link DatabaseInformation}.
 * @author
 */
@Service
@Transactional
public class DatabaseInformationService {


    private final DatabaseInformationRepository repository;

    public DatabaseInformationService(DatabaseInformationRepository repo) {
         this.repository = repo;
    }

    public DatabaseInformation findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<DatabaseInformation> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public DatabaseInformation create(DatabaseInformation d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public DatabaseInformation update(DatabaseInformation d) {
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

	public Page<DatabaseInformation> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<DatabaseInformation> findAllSpecification(Specification<DatabaseInformation> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
