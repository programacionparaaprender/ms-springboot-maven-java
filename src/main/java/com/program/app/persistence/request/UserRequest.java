package com.program.app.persistence.request;

import org.springframework.data.relational.core.mapping.Column;

import com.program.app.persistence.entity.UserEntity;
import lombok.Data;


@Data
public class UserRequest {
	private String picture;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String country;
    private String state;
    private String city;
    private String phone;
    private String address;
    
    public UserEntity convert() {
    	UserEntity entity = new UserEntity();
    	entity.setPicture(picture);
    	entity.setFirstName(firstName);
    	entity.setLastName(lastName);
    	entity.setUsername(username);
    	entity.setEmail(email);
        entity.setCountry(country);
        entity.setState(state);
        entity.setCity(city);
        entity.setPhone(phone);
        entity.setAddress(address);  
    	return entity;
    }
}
