
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ApplicationGroupMemberRepository;
import com.silo.backend.domain.model.entity.ApplicationGroupMember;
import com.silo.backend.service.ApplicationGroupMemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link ApplicationGroupMember}.
 * @author
 */
@Service
@Transactional
public class ApplicationGroupMemberService {


    private final ApplicationGroupMemberRepository repository;

    public ApplicationGroupMemberService(ApplicationGroupMemberRepository repo) {
         this.repository = repo;
    }

    public ApplicationGroupMember findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<ApplicationGroupMember> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public ApplicationGroupMember create(ApplicationGroupMember d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public ApplicationGroupMember update(ApplicationGroupMember d) {
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

	public Page<ApplicationGroupMember> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<ApplicationGroupMember> findAllSpecification(Specification<ApplicationGroupMember> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
