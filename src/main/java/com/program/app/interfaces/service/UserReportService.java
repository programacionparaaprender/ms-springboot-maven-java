package com.program.app.interfaces.service;

import org.springframework.stereotype.Service;

import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserReportService {
    private final UserRepository repository;

    public UserReportService(UserRepository repository) {
        this.repository = repository;
    }

    public Flux<UserEntity> findAll() {
        return repository.findAll();
    }

    public Mono<UserEntity> findById(Long id) {
        return repository.findById(id);
    }
}