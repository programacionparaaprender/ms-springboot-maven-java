package com.program.app.web.rest;

import com.program.app.persistence.entity.SubCategoryEntity;
import com.program.app.persistence.repository.SubCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryRestController {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryRestController(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    // Obtener todas las subcategorías
    @GetMapping
    public Flux<SubCategoryEntity> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    // Obtener subcategoría por ID
    @GetMapping("/{id}")
    public Mono<SubCategoryEntity> getSubCategoryById(@PathVariable Long id) {
        return subCategoryRepository.findById(id);
    }

    // Crear nueva subcategoría
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SubCategoryEntity> createSubCategory(@RequestBody SubCategoryEntity subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    // Actualizar subcategoría
    @PutMapping("/{id}")
    public Mono<SubCategoryEntity> updateSubCategory(@PathVariable Long id, @RequestBody SubCategoryEntity subCategory) {
        return subCategoryRepository.findById(id)
                .flatMap(existing -> {
                    subCategory.setId(existing.getId()); // Mantener el ID original
                    return subCategoryRepository.save(subCategory);
                });
    }

    // Eliminar subcategoría
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSubCategory(@PathVariable Long id) {
        return subCategoryRepository.deleteById(id);
    }
}
