package com.program.app.web.rest;

import com.program.app.application.UserService;
import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.request.UserRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<UserEntity> create(@RequestBody UserRequest userRequest) {
    	UserEntity user = userRequest.convert();
        return service.save(user);
    }

    @GetMapping
    public Flux<UserEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserEntity>> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}