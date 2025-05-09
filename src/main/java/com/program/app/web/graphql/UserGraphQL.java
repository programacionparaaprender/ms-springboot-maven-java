package com.program.app.web.graphql;

import com.program.app.application.CreateUserUseCase;
import com.program.app.application.GetAllUsersUseCase;
import com.program.app.application.GetByIdUserUseCase;
import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.request.UserRequest;

import org.springframework.graphql.data.method.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserGraphQL {

	private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetByIdUserUseCase getByIdUserUseCase;
    
    
    public UserGraphQL(CreateUserUseCase createUserUseCase, GetAllUsersUseCase getAllUsersUseCase, GetByIdUserUseCase getByIdUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getByIdUserUseCase = getByIdUserUseCase;
    }

    @QueryMapping
    public Flux<UserEntity> allUsers() {
        return getAllUsersUseCase.execute();
    }

    @QueryMapping
    public Mono<UserEntity> userById(@Argument Long id) {
        return getByIdUserUseCase.execute(id); 
    }


    @MutationMapping
    public Mono<UserEntity> createUser(@Argument String nombre, @Argument String email, @Argument String password) {
        UserRequest user = new UserRequest();
        user.setNombre(nombre);
        user.setEmail(email);
        user.setPassword(password);
        return createUserUseCase.execute(user);
    }
}
