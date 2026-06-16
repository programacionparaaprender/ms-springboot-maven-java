package com.program.app.application;

import org.springframework.stereotype.Service;

import com.program.app.interfaces.service.CategoryReportService;
import com.program.app.persistence.entity.CategoryEntity;

import reactor.core.publisher.Flux;

@Service
public class GetAllCategoriesUseCase {

    private final CategoryReportService service;

    public GetAllCategoriesUseCase(CategoryReportService service) {
        this.service = service;
    }

    public Flux<CategoryEntity> execute() {
        return service.findAll();
    }
}
