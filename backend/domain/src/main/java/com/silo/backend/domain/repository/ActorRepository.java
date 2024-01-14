package com.silo.backend.domain.repository;

import com.silo.backend.domain.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <h2>ActorRepository</h2>
 *
 * createdAt : 2024-01-13 - Time 21:38:33
 * <p>
 * Description: Spring Data repository for the {@link Actor} entity.
 * 
 * @author
 */
@Repository
public interface ActorRepository  extends JpaRepository<Actor, Long> , JpaSpecificationExecutor<Actor> {

}
