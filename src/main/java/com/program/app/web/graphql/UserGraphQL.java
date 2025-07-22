package com.program.app.web.graphql;

import com.program.app.application.CreateUserUseCase;
import com.program.app.application.GetAllUsersUseCase;
import com.program.app.application.GetByIdUserUseCase;
import com.program.app.application.UpdateByIdUserUseCase;
import com.program.app.application.UserRemovableUseCase;
import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.request.UserRequest;

import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserGraphQL {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetByIdUserUseCase getByIdUserUseCase;
    private final UserRemovableUseCase userRemovableUseCase;
    private final UpdateByIdUserUseCase updateByIdUserUseCase;
    
    public UserGraphQL(
        CreateUserUseCase createUserUseCase, 
        GetAllUsersUseCase getAllUsersUseCase, 
        GetByIdUserUseCase getByIdUserUseCase, 
        UserRemovableUseCase userRemovableUseCase,
        UpdateByIdUserUseCase updateByIdUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getByIdUserUseCase = getByIdUserUseCase;
        this.userRemovableUseCase = userRemovableUseCase;
        this.updateByIdUserUseCase = updateByIdUserUseCase;
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
    public Mono<UserEntity> createUser(
        @Argument String nombre, 
        @Argument String email, 
        @Argument String password
    ) {
        UserRequest user = new UserRequest();
        user.setNombre(nombre);
        user.setEmail(email);
        user.setPassword(password);
        return createUserUseCase.execute(user);
    }

    // ✅ Nuevo: Mutation para actualizar un usuario
    @MutationMapping
    public Mono<UserEntity> updateUser(
        @Argument Long id,
        @Argument String nombre,
        @Argument String email,
        @Argument String password
    ) {
        UserRequest userRequest = new UserRequest();
        userRequest.setNombre(nombre);
        userRequest.setEmail(email);
        userRequest.setPassword(password);
        return updateByIdUserUseCase.execute(userRequest, id);
    }

    // ✅ Nuevo: Mutation para eliminar un usuario
    @MutationMapping
    public Mono<Boolean> deleteUser(@Argument Long id) {
        return userRemovableUseCase.execute(id)
            .thenReturn(true) // Si se elimina correctamente, retorna true
            .onErrorReturn(false); // Si falla, retorna false
    }
}