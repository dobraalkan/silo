package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.CustomEnvironmentUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>CustomEnvironmentUsageRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link CustomEnvironmentUsage} entity.
 * 
 * @author
 */
@Repository
public interface CustomEnvironmentUsageRepository  extends JpaRepository<CustomEnvironmentUsage, Long> , JpaSpecificationExecutor<CustomEnvironmentUsage> {

}
