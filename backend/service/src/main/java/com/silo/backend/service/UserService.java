
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.UserRepository;
import com.silo.backend.domain.model.entity.User;
import com.silo.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link User}.
 * @author
 */
@Service
@Transactional
public class UserService {


    private final UserRepository repository;

    public UserService(UserRepository repo) {
         this.repository = repo;
    }

    public User findById(String id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<User> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public User create(User d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public User update(User d) {
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

	public Page<User> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<User> findAllSpecification(Specification<User> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
