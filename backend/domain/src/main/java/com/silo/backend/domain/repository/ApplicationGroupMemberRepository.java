package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.ApplicationGroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ApplicationGroupMemberRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:34
 * <p>
 * Description: Spring Data repository for the {@link ApplicationGroupMember} entity.
 * 
 * @author
 */
@Repository
public interface ApplicationGroupMemberRepository  extends JpaRepository<ApplicationGroupMember, Long> , JpaSpecificationExecutor<ApplicationGroupMember> {

}
