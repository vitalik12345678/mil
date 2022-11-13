package com.data.mil.repository;

import com.data.mil.enums.GenderEnum;
import com.data.mil.model.Role;
import com.data.mil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query
    Optional<User> findByEmail(String email);

    @Query
    Optional<User> findById(Long id);

    List<User> findAllByRole(Role role);

    @Query
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
}
