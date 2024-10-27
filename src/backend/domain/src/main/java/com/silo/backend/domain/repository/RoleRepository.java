package com.silo.backend.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silo.backend.domain.model.entity.user.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role,String>  {

    Optional<Role> findByName (String name);
}
