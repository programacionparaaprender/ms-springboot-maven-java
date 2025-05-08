package com.program.app.web.graphql;

import com.program.app.interfaces.service.UserService;
import com.program.app.persistence.entity.UserEntity;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserGraphQL {

    private final UserService userService;

    public UserGraphQL(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public Flux<UserEntity> allUsers() {
        return userService.findAll();
    }

    @QueryMapping
    public Mono<UserEntity> userById(@Argument Long id) {
        return userService.findById(id);
    }

    @MutationMapping
    public Mono<UserEntity> createUser(@Argument String nombre, @Argument String email, @Argument String password) {
        UserEntity user = new UserEntity();
        user.setNombre(nombre);
        user.setEmail(email);
        user.setPassword(password);
        return userService.save(user);
    }
}
