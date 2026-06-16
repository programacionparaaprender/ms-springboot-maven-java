package com.program.app.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("disputes")
@AllArgsConstructor
@NoArgsConstructor
public class DisputeEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("id_product")
    private Integer idProduct;

    @Column("transmitter")
    private String transmitter;

    @Column("receiver")
    private String receiver;

    @Column("message")
    private String message;

    @Column("answer")
    private String answer;
}
