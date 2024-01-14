
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.RoleRepository;
import com.silo.backend.domain.model.entity.Role;
import com.silo.backend.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link Role}.
 * @author
 */
@Service
@Transactional
public class RoleService {


    private final RoleRepository repository;

    public RoleService(RoleRepository repo) {
         this.repository = repo;
    }

    public Role findById(String id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<Role> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public Role create(Role d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public Role update(Role d) {
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

	public Page<Role> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Role> findAllSpecification(Specification<Role> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
