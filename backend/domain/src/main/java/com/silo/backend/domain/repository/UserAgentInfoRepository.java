package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.UserAgentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>UserAgentInfoRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:35
 * <p>
 * Description: Spring Data repository for the {@link UserAgentInfo} entity.
 * 
 * @author
 */
@Repository
public interface UserAgentInfoRepository  extends JpaRepository<UserAgentInfo, Integer> , JpaSpecificationExecutor<UserAgentInfo> {

}
