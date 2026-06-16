package com.program.app.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("sales")
@AllArgsConstructor
@NoArgsConstructor
public class SaleEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("id_order")
    private Integer idOrder;

    @Column("customer")
    private String customer;

    @Column("product")
    private String product;

    @Column("quantity")
    private Integer quantity;

    @Column("unit_price")
    private Double unitPrice;

    @Column("total")
    private Double total;

    @Column("commision")
    private Double commision;

    @Column("payment_method")
    private String paymentMethod;

    @Column("id_payment")
    private String idPayment;
}
