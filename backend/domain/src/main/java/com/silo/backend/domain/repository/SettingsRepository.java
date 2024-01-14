package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>SettingsRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:35
 * <p>
 * Description: Spring Data repository for the {@link Settings} entity.
 * 
 * @author
 */
@Repository
public interface SettingsRepository  extends JpaRepository<Settings, String> , JpaSpecificationExecutor<Settings> {

}
