package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.RelationshipKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>RelationshipKindRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link RelationshipKind} entity.
 * 
 * @author
 */
@Repository
public interface RelationshipKindRepository  extends JpaRepository<RelationshipKind, Long> , JpaSpecificationExecutor<RelationshipKind> {

}
