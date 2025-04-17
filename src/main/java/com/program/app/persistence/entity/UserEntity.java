package com.program.app.persistence.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table("users") 
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("nombre")
    private String nombre;

    @Column("email")
    private String email;

    @Column("password")
    private String password;
}