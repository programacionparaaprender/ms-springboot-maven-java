package com.program.app.persistence.request;

import org.springframework.data.relational.core.mapping.Column;

import com.program.app.persistence.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
	private String nombre;
    private String email;
    private String password;
    
    public UserEntity convert() {
    	UserEntity entity = new UserEntity();
    	entity.setNombre(nombre);
    	entity.setEmail(email);
    	entity.setPassword(password);
    	return entity;
    }
}
