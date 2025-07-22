package com.program.app.web.rest;

import com.program.app.application.CreateUserUseCase;
import com.program.app.application.GetAllUsersUseCase;
import com.program.app.application.GetByIdUserUseCase;
import com.program.app.application.UpdateByIdUserUseCase;
import com.program.app.application.UserRemovableUseCase;
import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.request.UserRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetByIdUserUseCase getByIdUserUseCase;
    private final UserRemovableUseCase userRemovableUseCase;
    private final UpdateByIdUserUseCase updateByIdUserUseCase;
    
    public UserRestController(CreateUserUseCase createUserUseCase, GetAllUsersUseCase getAllUsersUseCase, GetByIdUserUseCase getByIdUserUseCase, UserRemovableUseCase userRemovableUseCase,
    		UpdateByIdUserUseCase updateByIdUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getByIdUserUseCase = getByIdUserUseCase;
        this.userRemovableUseCase = userRemovableUseCase;
        this.updateByIdUserUseCase = updateByIdUserUseCase;
    }

    @PostMapping
    public Mono<UserEntity> create(@RequestBody UserRequest userRequest) {
        return this.createUserUseCase.execute(userRequest);
    }
    
    @PutMapping("/{id}")
    public Mono<UserEntity> update(@RequestBody UserRequest userRequest, @PathVariable Long id) {
        return this.updateByIdUserUseCase.execute(userRequest, id);
    }

    @GetMapping
    public Flux<UserEntity> getAll() {
        return this.getAllUsersUseCase.execute();
    }

    @GetMapping("/{id}")
    public Mono<UserEntity> getById(@PathVariable Long id) {
        return this.getByIdUserUseCase.execute(id);
    }
    
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
    	return this.userRemovableUseCase.execute(id);
    }
    
}