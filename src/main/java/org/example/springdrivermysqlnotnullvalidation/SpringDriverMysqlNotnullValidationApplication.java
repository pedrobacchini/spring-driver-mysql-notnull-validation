package org.example.springdrivermysqlnotnullvalidation;

import org.example.springdrivermysqlnotnullvalidation.model.ConsumerWalletJudicialBlockDocument;
import org.example.springdrivermysqlnotnullvalidation.model.ConsumerWalletJudicialBlockIdDocument;
import org.example.springdrivermysqlnotnullvalidation.model.OwnerTypeEnum;
import org.example.springdrivermysqlnotnullvalidation.repository.ConsumerWalletJudicialBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class SpringDriverMysqlNotnullValidationApplication implements CommandLineRunner {

    @Autowired
    private ConsumerWalletJudicialBlockRepository consumerWalletJudicialBlockRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDriverMysqlNotnullValidationApplication.class, args);
    }


    @Override
    public void run(final String... args) {
        final var consumerWalletJudicialBlockDocument = new ConsumerWalletJudicialBlockDocument(
            new ConsumerWalletJudicialBlockIdDocument(1L, null),
            1L,
            BigDecimal.TEN,
            true,
            LocalDateTime.now(),
            LocalDateTime.now(),
            BigDecimal.ZERO
        );
        consumerWalletJudicialBlockRepository.save(consumerWalletJudicialBlockDocument);
    }

}
