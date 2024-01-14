package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.DatabaseUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>DatabaseUsageRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link DatabaseUsage} entity.
 * 
 * @author
 */
@Repository
public interface DatabaseUsageRepository  extends JpaRepository<DatabaseUsage, Long> , JpaSpecificationExecutor<DatabaseUsage> {

}
