package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.ServerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ServerInformationRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:35
 * <p>
 * Description: Spring Data repository for the {@link ServerInformation} entity.
 * 
 * @author
 */
@Repository
public interface ServerInformationRepository  extends JpaRepository<ServerInformation, Long> , JpaSpecificationExecutor<ServerInformation> {

}
