package com.program.app.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("stores")
@AllArgsConstructor
@NoArgsConstructor
public class StoreEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("username")
    private String username;

    @Column("store")
    private String store;

    @Column("logo")
    private String logo;

    @Column("cover")
    private String cover;

    @Column("abstract")
    private String abstractText;

    @Column("about")
    private String about;

    @Column("email")
    private String email;

    @Column("address")
    private String address;

    @Column("phone")
    private String phone;

    @Column("social")
    private String social; // Puede usarse como JSON en String

    @Column("products")
    private Integer products;
}
