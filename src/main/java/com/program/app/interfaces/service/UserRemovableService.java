package com.program.app.interfaces.service;

import org.springframework.stereotype.Service;

import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserRemovableService {
    private final UserRepository repository;

    public UserRemovableService(UserRepository repository) {
        this.repository = repository;
    }

    public Mono<UserEntity> save(UserEntity user) {
        return repository.save(user);
    }

    public Flux<UserEntity> findAll() {
        return repository.findAll();
    }

    public Mono<UserEntity> findById(Long id) {
        return repository.findById(id);
    }
}