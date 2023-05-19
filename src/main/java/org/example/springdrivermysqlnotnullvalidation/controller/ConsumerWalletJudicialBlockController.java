package org.example.springdrivermysqlnotnullvalidation.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springdrivermysqlnotnullvalidation.model.ConsumerWalletJudicialBlockDocument;
import org.example.springdrivermysqlnotnullvalidation.repository.ConsumerWalletJudicialBlockRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("block")
@Slf4j
public class ConsumerWalletJudicialBlockController {

    private final ConsumerWalletJudicialBlockRepository consumerWalletJudicialBlockRepository;

    public ConsumerWalletJudicialBlockController(final ConsumerWalletJudicialBlockRepository consumerWalletJudicialBlockRepository) {
        this.consumerWalletJudicialBlockRepository = consumerWalletJudicialBlockRepository;
    }

    @PostMapping("/1")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumerWalletJudicialBlockDocument insert(@RequestBody @Valid final ConsumerWalletJudicialBlockDocument consumerWalletJudicialBlockDocument) {
        log.info(String.format("after insert at db: %s", consumerWalletJudicialBlockDocument.toString()));
        return consumerWalletJudicialBlockRepository.save(consumerWalletJudicialBlockDocument);
    }

}
