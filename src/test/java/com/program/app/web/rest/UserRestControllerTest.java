package com.program.app.web.rest;

import com.program.app.interfaces.service.UserService;
import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.request.UserRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@WebFluxTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserService userService;

    @Test
    void testCreateUser() {
        UserRequest request = new UserRequest("John", "Doe", "john@example.com");
        UserEntity savedUser = new UserEntity(1L, "John", "Doe", "john@example.com");

        when(userService.save(any(UserEntity.class))).thenReturn(Mono.just(savedUser));

        webTestClient.post()
                .uri("/api/users")
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.name").isEqualTo("John");
    }

    @Test
    void testGetAllUsers() {
        UserEntity user1 = new UserEntity(1L, "John", "Doe", "john@example.com");
        UserEntity user2 = new UserEntity(2L, "Jane", "Smith", "jane@example.com");

        when(userService.findAll()).thenReturn(Flux.just(user1, user2));

        webTestClient.get()
                .uri("/api/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(UserEntity.class)
                .hasSize(2);
    }

    @Test
    void testGetUserById_found() {
        UserEntity user = new UserEntity(1L, "John", "Doe", "john@example.com");

        when(userService.findById(1L)).thenReturn(Mono.just(user));

        webTestClient.get()
                .uri("/api/users/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.name").isEqualTo("John");
    }

    @Test
    void testGetUserById_notFound() {
        when(userService.findById(99L)).thenReturn(Mono.empty());

        webTestClient.get()
                .uri("/api/users/99")
                .exchange()
                .expectStatus().isNotFound();
    }
}
