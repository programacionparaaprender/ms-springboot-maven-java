package com.program.app.interfaces.service;

import org.springframework.stereotype.Service;

import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserRemovableService {
    private final UserRepository repository;

    public UserRemovableService(UserRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> delete(UserEntity user) {
        return repository.delete(user);
    }
    
    public Mono<Void> delete(Long id) {
        return repository.deleteById(id);
    }
}