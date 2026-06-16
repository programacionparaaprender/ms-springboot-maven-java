package com.program.app.interfaces.service;

import org.springframework.stereotype.Service;

import com.program.app.persistence.entity.CategoryEntity;
import com.program.app.persistence.repository.CategoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryReportService {

    private final CategoryRepository repository;

    public CategoryReportService(CategoryRepository repository) {
        this.repository = repository;
    }

    // Obtener todas las categorías
    public Flux<CategoryEntity> findAll() {
        return repository.findAll();
    }

    // Buscar categoría por ID
    public Mono<CategoryEntity> findById(Long id) {
        return repository.findById(id);
    }

    // Buscar categoría por nombre
    public Flux<CategoryEntity> findByName(String name) {
        return repository.findByName(name);
    }

    // Buscar categoría por URL (única)
    public Mono<CategoryEntity> findByUrl(String url) {
        return repository.findByUrl(url);
    }
}
