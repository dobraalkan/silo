
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ThumbnailRepository;
import com.silo.backend.domain.model.entity.Thumbnail;
import com.silo.backend.service.ThumbnailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link Thumbnail}.
 * @author
 */
@Service
@Transactional
public class ThumbnailService {


    private final ThumbnailRepository repository;

    public ThumbnailService(ThumbnailRepository repo) {
         this.repository = repo;
    }

    public Thumbnail findById(String id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<Thumbnail> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public Thumbnail create(Thumbnail d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public Thumbnail update(Thumbnail d) {
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

	public Page<Thumbnail> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Thumbnail> findAllSpecification(Specification<Thumbnail> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
