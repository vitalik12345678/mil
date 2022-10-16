package com.data.mil.repository;

import com.data.mil.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    /*@Query
    Optional<Role> findById(Integer id);*/

    @Query
    Optional<Role> findByName(String name);

   /* @Query
    Optional<DRoleEntity> findByName(String name);*/
}
