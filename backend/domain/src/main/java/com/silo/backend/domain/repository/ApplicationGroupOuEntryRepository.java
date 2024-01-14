package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.ApplicationGroupOuEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ApplicationGroupOuEntryRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link ApplicationGroupOuEntry} entity.
 * 
 * @author
 */
@Repository
public interface ApplicationGroupOuEntryRepository  extends JpaRepository<ApplicationGroupOuEntry, Long> , JpaSpecificationExecutor<ApplicationGroupOuEntry> {

}
