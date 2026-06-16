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

    @Column("picture")
    private String picture;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("username")
    private String username;

    @Column("email")
    private String email;

    @Column("country")
    private String country;

    @Column("state")
    private String state;

    @Column("city")
    private String city;

    @Column("phone")
    private String phone;

    @Column("address")
    private String address;
}
