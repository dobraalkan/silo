package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.ApplicationRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ApplicationRelationshipRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link ApplicationRelationship} entity.
 * 
 * @author
 */
@Repository
public interface ApplicationRelationshipRepository  extends JpaRepository<ApplicationRelationship, Long> , JpaSpecificationExecutor<ApplicationRelationship> {

}
