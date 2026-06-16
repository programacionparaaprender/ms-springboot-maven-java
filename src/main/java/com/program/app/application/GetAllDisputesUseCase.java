package com.program.app.application;

import com.program.app.persistence.entity.DisputeEntity;
import com.program.app.persistence.repository.DisputeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllDisputesUseCase {

    private final DisputeRepository disputeRepository;

    public GetAllDisputesUseCase(DisputeRepository disputeRepository) {
        this.disputeRepository = disputeRepository;
    }

    public Flux<DisputeEntity> execute() {
        return disputeRepository.findAll();
    }
}

