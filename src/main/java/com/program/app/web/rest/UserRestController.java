package com.program.app.web.rest;

import com.program.app.application.CreateUserUseCase;
import com.program.app.application.GetAllUsersUseCase;
import com.program.app.application.GetByIdUserUseCase;
import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.request.UserRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetByIdUserUseCase getByIdUserUseCase;
    
    
    public UserRestController(CreateUserUseCase createUserUseCase, GetAllUsersUseCase getAllUsersUseCase, GetByIdUserUseCase getByIdUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getByIdUserUseCase = getByIdUserUseCase;
    }

    @PostMapping
    public Mono<UserEntity> create(@RequestBody UserRequest userRequest) {
        return this.createUserUseCase.execute(userRequest);
    }

    @GetMapping
    public Flux<UserEntity> getAll() {
        return this.getAllUsersUseCase.execute();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserEntity>> getById(@PathVariable Long id) {
        return this.getByIdUserUseCase.execute(id);
    }
}