package org.example.springdrivermysqlnotnullvalidation.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springdrivermysqlnotnullvalidation.model.ConstraintValidation;
import org.example.springdrivermysqlnotnullvalidation.repository.ConstraintValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("validation")
@Slf4j
public class ConstraintValidationController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final ConstraintValidationRepository constraintValidationRepository;

    public ConstraintValidationController(final ConstraintValidationRepository constraintValidationRepository) {
        this.constraintValidationRepository = Objects.requireNonNull(constraintValidationRepository);
    }

    @PostMapping("/1")
    @ResponseStatus(HttpStatus.CREATED)
    public ConstraintValidation insert1(@RequestBody @Valid final ConstraintValidation constraintValidation) {
        log.info(String.format("after insert at db: %s", constraintValidation.toString()));
        return constraintValidationRepository.save(constraintValidation);
    }

    @PostMapping("/2")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert2(@RequestBody @Valid final ConstraintValidation constraintValidation) {
        entityManager.createNativeQuery("INSERT INTO constraint_validation (name, type) VALUES (?,?) ")
            .setParameter(1, constraintValidation.getName())
            .setParameter(2, constraintValidation.getType())
            .executeUpdate();
    }

    @PostMapping("/3")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert3(@RequestBody @Valid final ConstraintValidation constraintValidation) {
        entityManager.persist(constraintValidation);
    }

    @PostMapping("/4")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert4(@RequestBody @Valid final ConstraintValidation constraintValidation) {
        jdbcTemplate.update(
            "INSERT INTO constraint_validation (name, type) VALUES (?,?,?,?,?,?,?,?) ",
            constraintValidation.getName(),
            constraintValidation.getType());
    }

}
