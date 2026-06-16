package com.program.app.persistence.repository;

import com.program.app.persistence.entity.CategoryEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface CategoryRepository extends ReactiveCrudRepository<CategoryEntity, Long> {

    Flux<CategoryEntity> findByName(String name);

    Mono<CategoryEntity> findByUrl(String url);

    @Query("UPDATE categories SET name = :name, title_list = :titleList, url = :url, image = :image, icon = :icon, view = :view WHERE id = :id")
    Mono<Void> updateCategoryById(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("titleList") String titleList,
            @Param("url") String url,
            @Param("image") String image,
            @Param("icon") String icon,
            @Param("view") Integer view
    );
}
