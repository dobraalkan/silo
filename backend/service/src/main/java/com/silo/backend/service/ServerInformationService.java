
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.ServerInformationRepository;
import com.silo.backend.domain.model.entity.ServerInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link ServerInformation}.
 * @author
 */
@Service
@Transactional
public class ServerInformationService {


    private final ServerInformationRepository repository;

    public ServerInformationService(ServerInformationRepository repo) {
         this.repository = repo;
    }

    public ServerInformation findById(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<ServerInformation> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public ServerInformation create(ServerInformation d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public ServerInformation update(ServerInformation d) {
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

	public Page<ServerInformation> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<ServerInformation> findAllSpecification(Specification<ServerInformation> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
