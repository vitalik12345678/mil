package com.data.mil.repository;


import com.data.mil.model.BloodPressure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface BloodPressureRepository extends JpaRepository<com.data.mil.model.BloodPressure,Long> {

    @Query
    Optional<BloodPressure> findById(Long id);
}
