package com.program.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String nombre;
    private String email;
    private String password;

    // Getters y Setters
}
