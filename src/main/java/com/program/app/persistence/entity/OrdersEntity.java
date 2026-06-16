package com.program.app.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrdersEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("id_order")
    private Integer idOrder;

    @Column("stage")
    private String stage;

    @Column("transmitter")
    private String transmitter;

    @Column("receiver")
    private String receiver;

    @Column("dispute")
    private String dispute;

    @Column("answer")
    private String answer;
}
