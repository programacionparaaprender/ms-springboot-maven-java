package com.program.app.persistence.repository;

import com.program.app.persistence.entity.DisputeEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DisputeRepository extends ReactiveCrudRepository<DisputeEntity, Long> {

    // Buscar disputas por producto
    Flux<DisputeEntity> findByIdProduct(Integer idProduct);

    // Buscar disputas por transmisor
    Flux<DisputeEntity> findByTransmitter(String transmitter);

    // Buscar disputas por receptor
    Flux<DisputeEntity> findByReceiver(String receiver);

    // Actualizar una disputa por ID
    @Query("UPDATE disputes SET id_product = :idProduct, transmitter = :transmitter, receiver = :receiver, message = :message, answer = :answer WHERE id = :id")
    Mono<Void> updateDisputeById(
            @Param("id") Long id,
            @Param("idProduct") Integer idProduct,
            @Param("transmitter") String transmitter,
            @Param("receiver") String receiver,
            @Param("message") String message,
            @Param("answer") String answer
    );
}
