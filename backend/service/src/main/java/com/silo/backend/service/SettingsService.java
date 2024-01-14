
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.SettingsRepository;
import com.silo.backend.domain.model.entity.Settings;
import com.silo.backend.service.SettingsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link Settings}.
 * @author
 */
@Service
@Transactional
public class SettingsService {


    private final SettingsRepository repository;

    public SettingsService(SettingsRepository repo) {
         this.repository = repo;
    }

    public Settings findById(String id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<Settings> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public Settings create(Settings d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public Settings update(Settings d) {
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

    public void delete(String id) {
        repository.deleteById(id);
    }

	public Page<Settings> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Settings> findAllSpecification(Specification<Settings> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
