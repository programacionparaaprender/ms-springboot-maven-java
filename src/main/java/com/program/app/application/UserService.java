package com.program.app.application;


import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
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