package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.Complexity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ComplexityRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link Complexity} entity.
 * 
 * @author
 */
@Repository
public interface ComplexityRepository  extends JpaRepository<Complexity, Long> , JpaSpecificationExecutor<Complexity> {

}
