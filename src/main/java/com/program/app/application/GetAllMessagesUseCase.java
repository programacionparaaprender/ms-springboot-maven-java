package com.program.app.application;

import org.springframework.stereotype.Service;
import com.program.app.persistence.entity.MessageEntity;
import com.program.app.persistence.repository.MessageRepository;
import reactor.core.publisher.Flux;

@Service
public class GetAllMessagesUseCase {

    private final MessageRepository repository;

    public GetAllMessagesUseCase(MessageRepository repository) {
        this.repository = repository;
    }

    public Flux<MessageEntity> execute() {
        return repository.findAll();
    }
}
