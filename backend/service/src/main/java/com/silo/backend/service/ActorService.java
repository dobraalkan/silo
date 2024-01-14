
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ActorRepository;
import com.silo.backend.domain.model.entity.Actor;
import com.silo.backend.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link Actor}.
 * @author
 */
@Service
@Transactional
public class ActorService {


    private final ActorRepository repository;

    public ActorService(ActorRepository repo) {
         this.repository = repo;
    }

    public Actor findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<Actor> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public Actor create(Actor d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public Actor update(Actor d) {
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

	public Page<Actor> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Actor> findAllSpecification(Specification<Actor> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
