package com.program.app.application;

import org.springframework.stereotype.Service;
import com.program.app.persistence.entity.OrdersEntity;
import com.program.app.persistence.repository.OrdersRepository;

import reactor.core.publisher.Flux;

@Service
public class GetAllOrdersUseCase {

    private final OrdersRepository service;

    public GetAllOrdersUseCase(OrdersRepository service) {
        this.service = service;
    }

    public Flux<OrdersEntity> execute() {
        return service.findAll();
    }
}
