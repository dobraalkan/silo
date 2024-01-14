package com.silo.backend.service;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silo.backend.domain.model.entity.AccessLog;
import com.silo.backend.domain.repository.AccessLogRepository;

/**
 * Service Implementation for managing {@link AccessLog}.
 * @author
 */
@Service
@Transactional
public class AccessLogService {

    private AccessLogRepository repository;

    public AccessLogService(AccessLogRepository repo) {
         this.repository = repo;
    }

    public AccessLog findById(Integer id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<AccessLog> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public AccessLog create(AccessLog d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public AccessLog update(AccessLog d) {
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

    public void delete(Integer id) {
        repository.deleteById(id);
    }

	public Page<AccessLog> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<AccessLog> findAllSpecification(Specification<AccessLog> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
