package com.program.app.persistence.request;

import com.program.app.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRequestTest {

    @Test
    public void testConvert() {
        // Arrange
        UserRequest request = new UserRequest();
        request.setNombre("Juan");
        request.setEmail("juan@example.com");
        request.setPassword("password123");

        // Act
        UserEntity entity = request.convert();

        // Assert
        assertNotNull(entity);
        assertEquals("Juan", entity.getNombre());
        assertEquals("juan@example.com", entity.getEmail());
        assertEquals("password123", entity.getPassword());
    }
}
