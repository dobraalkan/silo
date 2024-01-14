package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.ApplicationComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ApplicationComponentRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link ApplicationComponent} entity.
 * 
 * @author
 */
@Repository
public interface ApplicationComponentRepository  extends JpaRepository<ApplicationComponent, Long> , JpaSpecificationExecutor<ApplicationComponent> {

}
