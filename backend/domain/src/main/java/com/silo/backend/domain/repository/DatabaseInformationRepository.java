package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.DatabaseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>DatabaseInformationRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link DatabaseInformation} entity.
 * 
 * @author
 */
@Repository
public interface DatabaseInformationRepository  extends JpaRepository<DatabaseInformation, Long> , JpaSpecificationExecutor<DatabaseInformation> {

}
