package com.silo.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.silo.backend.domain.model.entity.AccessLog;

/**
 * <h2>AccessLogRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:33
 * <p>
 * Description: Spring Data repository for the {@link AccessLog} entity.
 * 
 * @author
 */
@Repository
public interface AccessLogRepository  extends JpaRepository<AccessLog, Integer> , JpaSpecificationExecutor<AccessLog> {

}
