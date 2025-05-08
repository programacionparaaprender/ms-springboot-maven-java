package com.program.app.application;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.program.app.interfaces.service.UserReportService;
import com.program.app.persistence.entity.UserEntity;
import reactor.core.publisher.Mono;

@Service
public class GetByIdUserUseCase {
	private final UserReportService service;

    public GetByIdUserUseCase(UserReportService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserEntity>> execute(Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
