package org.example.springdrivermysqlnotnullvalidation.repository;

import org.example.springdrivermysqlnotnullvalidation.model.ConstraintValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstraintValidationRepository extends JpaRepository<ConstraintValidation, Long> {

}
