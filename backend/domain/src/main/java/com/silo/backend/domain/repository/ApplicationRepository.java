package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ApplicationRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:33
 * <p>
 * Description: Spring Data repository for the {@link Application} entity.
 * 
 * @author
 */
@Repository
public interface ApplicationRepository  extends JpaRepository<Application, Long> , JpaSpecificationExecutor<Application> {

}
