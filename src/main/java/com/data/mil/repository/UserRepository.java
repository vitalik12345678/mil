package com.data.mil.repository;

import com.data.mil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query
    Optional<User> findByEmail(String email);

    @Query
    Optional<User> findById(Long id);

    @Query
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
}
