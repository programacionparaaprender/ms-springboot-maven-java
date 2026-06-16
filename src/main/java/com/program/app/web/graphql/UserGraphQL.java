package com.program.app.web.graphql;

import com.program.app.application.users.CreateUserUseCase;
import com.program.app.application.users.GetAllUsersUseCase;
import com.program.app.application.users.GetByIdUserUseCase;
import com.program.app.application.users.UpdateByIdUserUseCase;
import com.program.app.application.users.UserRemovableUseCase;
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

    // ✅ Query: lista todos los usuarios
    @QueryMapping
    public Flux<UserEntity> allUsers() {
        return getAllUsersUseCase.execute();
    }

    // ✅ Query: obtiene un usuario por ID
    @QueryMapping
    public Mono<UserEntity> userById(@Argument Long id) {
        return getByIdUserUseCase.execute(id);
    }

    // ✅ Mutation: crear usuario
    @MutationMapping
    public Mono<UserEntity> createUser(
        @Argument String picture,
        @Argument String firstName,
        @Argument String lastName,
        @Argument String username,
        @Argument String email,
        @Argument String country,
        @Argument String state,
        @Argument String city,
        @Argument String phone,
        @Argument String address
    ) {
        UserRequest user = new UserRequest();
        user.setPicture(picture);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setCountry(country);
        user.setState(state);
        user.setCity(city);
        user.setPhone(phone);
        user.setAddress(address);

        return createUserUseCase.execute(user);
    }

    // ✅ Mutation: actualizar usuario
    @MutationMapping
    public Mono<UserEntity> updateUser(
        @Argument Long id,
        @Argument String picture,
        @Argument String firstName,
        @Argument String lastName,
        @Argument String username,
        @Argument String email,
        @Argument String country,
        @Argument String state,
        @Argument String city,
        @Argument String phone,
        @Argument String address
    ) {
        UserRequest userRequest = new UserRequest();
        userRequest.setPicture(picture);
        userRequest.setFirstName(firstName);
        userRequest.setLastName(lastName);
        userRequest.setUsername(username);
        userRequest.setEmail(email);
        userRequest.setCountry(country);
        userRequest.setState(state);
        userRequest.setCity(city);
        userRequest.setPhone(phone);
        userRequest.setAddress(address);

        return updateByIdUserUseCase.execute(userRequest, id);
    }

    // ✅ Mutation: eliminar usuario
    @MutationMapping
    public Mono<Boolean> deleteUser(@Argument Long id) {
        return userRemovableUseCase.execute(id)
            .thenReturn(true)
            .onErrorReturn(false);
    }
}
