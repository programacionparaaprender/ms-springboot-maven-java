package com.program.app.web.rest;

//import com.program.app.application.CreateCategoryUseCase;
import com.program.app.application.GetAllCategoriesUseCase;
//import com.program.app.application.GetCategoryByIdUseCase;
//import com.program.app.application.UpdateCategoryUseCase;
//import com.program.app.application.DeleteCategoryUseCase;
import com.program.app.persistence.entity.CategoryEntity;
//import com.program.app.persistence.request.CategoryRequest;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

//    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
//    private final GetCategoryByIdUseCase getCategoryByIdUseCase;
//    private final UpdateCategoryUseCase updateCategoryUseCase;
//    private final DeleteCategoryUseCase deleteCategoryUseCase;

    public CategoryRestController(
//            CreateCategoryUseCase createCategoryUseCase,
            GetAllCategoriesUseCase getAllCategoriesUseCase
//            GetCategoryByIdUseCase getCategoryByIdUseCase,
//            UpdateCategoryUseCase updateCategoryUseCase,
//            DeleteCategoryUseCase deleteCategoryUseCase
            ) {
//        this.createCategoryUseCase = createCategoryUseCase;
        this.getAllCategoriesUseCase = getAllCategoriesUseCase;
//        this.getCategoryByIdUseCase = getCategoryByIdUseCase;
//        this.updateCategoryUseCase = updateCategoryUseCase;
//        this.deleteCategoryUseCase = deleteCategoryUseCase;
    }

//    @PostMapping
//    public Mono<CategoryEntity> create(@RequestBody CategoryRequest request) {
//        return createCategoryUseCase.execute(request);
//    }
//
//    @PutMapping("/{id}")
//    public Mono<CategoryEntity> update(@RequestBody CategoryRequest request, @PathVariable Long id) {
//        return updateCategoryUseCase.execute(request, id);
//    }

    @GetMapping
    public Flux<CategoryEntity> getAll() {
        return getAllCategoriesUseCase.execute();
    }

//    @GetMapping("/{id}")
//    public Mono<CategoryEntity> getById(@PathVariable Long id) {
//        return getCategoryByIdUseCase.execute(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public Mono<Void> delete(@PathVariable Long id) {
//        return deleteCategoryUseCase.execute(id);
//    }
}
