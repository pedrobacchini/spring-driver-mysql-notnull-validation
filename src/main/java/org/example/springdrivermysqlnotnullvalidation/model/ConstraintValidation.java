package org.example.springdrivermysqlnotnullvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "constraint_validation",
//    indexes = {@Index(name = "UNQ1_CONSTRAINT_VALIDATION", columnList = "name, type", unique = true)})
@Table(name = "constraint_validation",
    uniqueConstraints = @UniqueConstraint(name = "unq1_constraint_validation", columnNames = {"name", "type"}))
public class ConstraintValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @Override
    public String toString() {
        return "ConstraintValidation{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            '}';
    }

}
