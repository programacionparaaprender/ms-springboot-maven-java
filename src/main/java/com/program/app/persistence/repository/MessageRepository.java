package com.program.app.persistence.repository;

import com.program.app.persistence.entity.MessageEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageRepository extends ReactiveCrudRepository<MessageEntity, Long> {

    // Buscar mensajes por producto
    Flux<MessageEntity> findByIdProduct(Integer idProduct);

    // Buscar mensajes por transmisor
    Flux<MessageEntity> findByTransmitter(String transmitter);

    // Buscar mensajes por receptor
    Flux<MessageEntity> findByReceiver(String receiver);

    // Actualizar un mensaje por ID
    @Query("UPDATE messages SET id_product = :idProduct, transmitter = :transmitter, receiver = :receiver, message = :message, answer = :answer WHERE id = :id")
    Mono<Void> updateMessageById(
            @Param("id") Long id,
            @Param("idProduct") Integer idProduct,
            @Param("transmitter") String transmitter,
            @Param("receiver") String receiver,
            @Param("message") String message,
            @Param("answer") String answer
    );
}
