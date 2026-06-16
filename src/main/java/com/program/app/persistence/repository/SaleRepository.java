package com.program.app.persistence.repository;

import com.program.app.persistence.entity.SaleEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaleRepository extends ReactiveCrudRepository<SaleEntity, Long> {

    // Buscar ventas por id_order
    Flux<SaleEntity> findByIdOrder(Integer idOrder);

    // Buscar ventas por cliente
    Flux<SaleEntity> findByCustomer(String customer);

    // Buscar ventas por producto
    Flux<SaleEntity> findByProduct(String product);

    // Buscar por método de pago
    Flux<SaleEntity> findByPaymentMethod(String paymentMethod);

    // Buscar por id_payment (es único)
    Mono<SaleEntity> findByIdPayment(String idPayment);

    // Actualizar venta por ID
    @Query("UPDATE sales SET " +
           "id_order = :idOrder, customer = :customer, product = :product, quantity = :quantity, " +
           "unit_price = :unitPrice, total = :total, commision = :commision, " +
           "payment_method = :paymentMethod, id_payment = :idPayment " +
           "WHERE id = :id")
    Mono<Void> updateSaleById(
            @Param("id") Long id,
            @Param("idOrder") Integer idOrder,
            @Param("customer") String customer,
            @Param("product") String product,
            @Param("quantity") Integer quantity,
            @Param("unitPrice") Double unitPrice,
            @Param("total") Double total,
            @Param("commision") Double commision,
            @Param("paymentMethod") String paymentMethod,
            @Param("idPayment") String idPayment
    );
}
