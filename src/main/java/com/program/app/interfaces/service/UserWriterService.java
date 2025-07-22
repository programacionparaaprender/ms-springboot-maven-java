package com.program.app.interfaces.service;

import org.springframework.stereotype.Service;

import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserWriterService {
    private final UserRepository repository;

    public UserWriterService(UserRepository repository) {
        this.repository = repository;
    }

    public Mono<UserEntity> save(UserEntity user) {
        return repository.save(user);
    }
    
    public Mono<UserEntity> update(UserEntity updatedUser, Long id) {
    
        return repository.findById(id)
            .flatMap(existingUser -> {
                existingUser.setNombre(updatedUser.getNombre());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setPassword(updatedUser.getPassword());
                return repository.save(existingUser); 
            });
    }


}