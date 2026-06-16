package com.program.app.persistence.request;

import com.program.app.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRequestTest {

    @Test
    public void testConvert() {
        // Arrange
        UserRequest request = new UserRequest();
        request.setPicture("updatedUser.getPicture()");
        request.setFirstName("updatedUser.getFirstName()");
        request.setLastName("updatedUser.getLastName()");
        request.setUsername("updatedUser.getUsername()");
        request.setEmail("updatedUser.getEmail()");
        request.setCountry("updatedUser.getCountry()");
        request.setState("updatedUser.getState()");
        request.setCity("updatedUser.getCity()");
        request.setPhone("updatedUser.getPhone()");
        request.setAddress("updatedUser.getAddress()");  
        // Act
        UserEntity entity = request.convert();

        // Assert
        assertNotNull(entity);
        
        assertEquals("updatedUser.getPicture()", entity.getPicture());
        assertEquals("updatedUser.getFirstName()", entity.getFirstName());
        assertEquals("updatedUser.getLastName()", entity.getLastName());
        assertEquals("updatedUser.getUsername()", entity.getUsername());
        assertEquals("updatedUser.getEmail()", entity.getEmail());
        assertEquals("updatedUser.getCountry()", entity.getCountry());
        assertEquals("updatedUser.getState()", entity.getState());
        assertEquals("updatedUser.getCity()", entity.getCity());
        assertEquals("updatedUser.getPhone()", entity.getPhone());
        assertEquals("updatedUser.getAddress()", entity.getAddress());  
    }
}
