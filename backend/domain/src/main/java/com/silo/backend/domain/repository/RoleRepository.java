package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>RoleRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:35
 * <p>
 * Description: Spring Data repository for the {@link Role} entity.
 * 
 * @author
 */
@Repository
public interface RoleRepository  extends JpaRepository<Role, String> , JpaSpecificationExecutor<Role> {

}
