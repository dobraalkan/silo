package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>UserPreferenceRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:35
 * <p>
 * Description: Spring Data repository for the {@link UserPreference} entity.
 * 
 * @author
 */
@Repository
public interface UserPreferenceRepository  extends JpaRepository<UserPreference, String> , JpaSpecificationExecutor<UserPreference> {

}
