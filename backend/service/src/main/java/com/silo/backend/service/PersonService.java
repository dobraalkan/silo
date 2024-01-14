
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.PersonRepository;
import com.silo.backend.domain.model.entity.Person;
import com.silo.backend.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link Person}.
 * @author
 */
@Service
@Transactional
public class PersonService {


    private final PersonRepository repository;

    public PersonService(PersonRepository repo) {
         this.repository = repo;
    }

    public Person findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<Person> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public Person create(Person d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public Person update(Person d) {
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

	public Page<Person> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Person> findAllSpecification(Specification<Person> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
