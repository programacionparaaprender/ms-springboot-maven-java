package com.program.app.persistence.repository;

import com.program.app.persistence.entity.SubCategoryEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubCategoryRepository extends ReactiveCrudRepository<SubCategoryEntity, Long> {

    // Buscar por categoría principal
    Flux<SubCategoryEntity> findByCategory(String category);

    // Buscar por título de lista (title_list)
    Flux<SubCategoryEntity> findByTitleList(String titleList);

    // Buscar por nombre de subcategoría
    Flux<SubCategoryEntity> findByName(String name);

    // Buscar por URL (es única)
    Mono<SubCategoryEntity> findByUrl(String url);

    // Actualizar una subcategoría por ID
    @Query("UPDATE subcategories SET " +
           "category = :category, title_list = :titleList, name = :name, url = :url, " +
           "image = :image, products_inventory = :productsInventory, view = :view " +
           "WHERE id = :id")
    Mono<Void> updateSubCategoryById(
            @Param("id") Long id,
            @Param("category") String category,
            @Param("titleList") String titleList,
            @Param("name") String name,
            @Param("url") String url,
            @Param("image") String image,
            @Param("productsInventory") Integer productsInventory,
            @Param("view") Integer view
    );
}
