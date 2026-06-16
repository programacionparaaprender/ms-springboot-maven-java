package com.program.app.interfaces.service;

import org.springframework.data.relational.core.mapping.Column;
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
                existingUser.setPicture(updatedUser.getPicture());
                existingUser.setFirstName(updatedUser.getFirstName());
                existingUser.setLastName(updatedUser.getLastName());
                existingUser.setUsername(updatedUser.getUsername());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setCountry(updatedUser.getCountry());
                existingUser.setState(updatedUser.getState());
                existingUser.setCity(updatedUser.getCity());
                existingUser.setPhone(updatedUser.getPhone());
                existingUser.setAddress(updatedUser.getAddress());           
                return repository.save(existingUser); 
            });
    }
}