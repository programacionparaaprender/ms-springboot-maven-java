package com.program.app.application;


import org.springframework.stereotype.Service;

import com.program.app.interfaces.service.UserReportService;
import com.program.app.persistence.entity.UserEntity;
import reactor.core.publisher.Flux;

@Service
public class GetAllUsersUseCase {
	private final UserReportService service;
    public GetAllUsersUseCase(UserReportService service) {
        this.service = service;
    }

    public Flux<UserEntity> execute() {
        return service.findAll();
    }
}
