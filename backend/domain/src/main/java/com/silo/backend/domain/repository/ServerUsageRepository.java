package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.ServerUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ServerUsageRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:35
 * <p>
 * Description: Spring Data repository for the {@link ServerUsage} entity.
 * 
 * @author
 */
@Repository
public interface ServerUsageRepository  extends JpaRepository<ServerUsage, Long> , JpaSpecificationExecutor<ServerUsage> {

}
