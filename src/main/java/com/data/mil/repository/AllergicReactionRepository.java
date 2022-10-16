package com.data.mil.repository;

import com.data.mil.model.AllergicReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergicReactionRepository extends JpaRepository<com.data.mil.model.AllergicReaction,Long> {

    @Query
    Optional<AllergicReaction> findById(Long id);

    @Query
    Optional<AllergicReaction> findByName(String name);

}
