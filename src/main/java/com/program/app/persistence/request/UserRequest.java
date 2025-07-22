package com.program.app.persistence.request;

import com.program.app.persistence.entity.UserEntity;
import lombok.Data;


@Data
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
