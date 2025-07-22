package com.program.app.persistence.repository;

import com.program.app.persistence.entity.UserEntity;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
    Mono<UserEntity> findByEmail(String email);
    @Query("UPDATE users SET nombre = :nombre, email:email, password = :password WHERE id = :id")
    Mono<Void> updateUserById(@Param("id") Long id,
                                 @Param("nombre") String nombre,
                                 @Param("email") String email,
                                 @Param("password") String password);
}
