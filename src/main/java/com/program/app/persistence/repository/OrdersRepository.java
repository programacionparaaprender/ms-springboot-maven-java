package com.program.app.persistence.repository;

import com.program.app.persistence.entity.OrdersEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrdersRepository extends ReactiveCrudRepository<OrdersEntity, Long> {

    // Buscar órdenes por id_order (código externo de la orden)
    Flux<OrdersEntity> findByIdOrder(Integer idOrder);

    // Buscar órdenes por etapa
    Flux<OrdersEntity> findByStage(String stage);

    // Buscar órdenes por transmisor
    Flux<OrdersEntity> findByTransmitter(String transmitter);

    // Buscar órdenes por receptor
    Flux<OrdersEntity> findByReceiver(String receiver);

    // Actualizar una orden por ID
    @Query("UPDATE orders SET id_order = :idOrder, stage = :stage, transmitter = :transmitter, receiver = :receiver, dispute = :dispute, answer = :answer WHERE id = :id")
    Mono<Void> updateOrderById(
            @Param("id") Long id,
            @Param("idOrder") Integer idOrder,
            @Param("stage") String stage,
            @Param("transmitter") String transmitter,
            @Param("receiver") String receiver,
            @Param("dispute") String dispute,
            @Param("answer") String answer
    );
}
