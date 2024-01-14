
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.OrganisationalUnitRepository;
import com.silo.backend.domain.model.entity.OrganisationalUnit;
import com.silo.backend.service.OrganisationalUnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link OrganisationalUnit}.
 * @author
 */
@Service
@Transactional
public class OrganisationalUnitService {


    private final OrganisationalUnitRepository repository;

    public OrganisationalUnitService(OrganisationalUnitRepository repo) {
         this.repository = repo;
    }

    public OrganisationalUnit findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<OrganisationalUnit> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public OrganisationalUnit create(OrganisationalUnit d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public OrganisationalUnit update(OrganisationalUnit d) {
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

	public Page<OrganisationalUnit> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<OrganisationalUnit> findAllSpecification(Specification<OrganisationalUnit> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
