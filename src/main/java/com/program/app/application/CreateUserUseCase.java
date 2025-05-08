package com.program.app.application;

import com.program.app.interfaces.service.UserWriterService;
import com.program.app.persistence.entity.UserEntity;
import com.program.app.persistence.request.UserRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateUserUseCase {

    private final UserWriterService service;

    public CreateUserUseCase(UserWriterService service) {
        this.service = service;
    }
    
    public Mono<UserEntity> execute(UserRequest userRequest) {
    	UserEntity user = userRequest.convert();
        return service.save(user);
    }
}
