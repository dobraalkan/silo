
package com.silo.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silo.backend.domain.repository.UserAgentInfoRepository;
import com.silo.backend.domain.model.entity.UserAgentInfo;
import com.silo.backend.service.UserAgentInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link UserAgentInfo}.
 * @author
 */
@Service
@Transactional
public class UserAgentInfoService {


    private final UserAgentInfoRepository repository;

    public UserAgentInfoService(UserAgentInfoRepository repo) {
         this.repository = repo;
    }

    public UserAgentInfo findById(Integer id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    public List<UserAgentInfo> findAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    public UserAgentInfo create(UserAgentInfo d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    public UserAgentInfo update(UserAgentInfo d) {
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

	public Page<UserAgentInfo> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<UserAgentInfo> findAllSpecification(Specification<UserAgentInfo> specs, Pageable pageable) {
		return repository.findAll(specs, pageable);
	}

}
