package com.program.app.persistence.repository;

import com.program.app.persistence.entity.StoreEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StoreRepository extends ReactiveCrudRepository<StoreEntity, Long> {

    // Buscar por username (único para la tienda)
    Mono<StoreEntity> findByUsername(String username);

    // Buscar por nombre de la tienda
    Flux<StoreEntity> findByStore(String store);

    // Buscar por email (único)
    Mono<StoreEntity> findByEmail(String email);

    // Actualizar una tienda por ID
    @Query("UPDATE stores SET " +
           "username = :username, store = :store, logo = :logo, cover = :cover, " +
           "abstract = :abstractText, about = :about, email = :email, address = :address, " +
           "phone = :phone, social = :social, products = :products " +
           "WHERE id = :id")
    Mono<Void> updateStoreById(
            @Param("id") Long id,
            @Param("username") String username,
            @Param("store") String store,
            @Param("logo") String logo,
            @Param("cover") String cover,
            @Param("abstractText") String abstractText,
            @Param("about") String about,
            @Param("email") String email,
            @Param("address") String address,
            @Param("phone") String phone,
            @Param("social") String social,
            @Param("products") Integer products
    );
}
