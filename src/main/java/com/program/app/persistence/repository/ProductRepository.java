package com.program.app.persistence.repository;

import com.program.app.persistence.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {

    // Buscar productos por tienda
    Flux<ProductEntity> findByStore(String store);

    // Buscar productos por categoría
    Flux<ProductEntity> findByCategory(String category);

    // Buscar productos por subcategoría
    Flux<ProductEntity> findBySubCategory(String subCategory);

    // Buscar producto por URL (es única en tu tabla)
    Mono<ProductEntity> findByUrl(String url);

    // Actualizar producto por ID
    @Query("UPDATE products SET " +
           "feedback = :feedback, store = :store, category = :category, title_list = :titleList, " +
           "sub_category = :subCategory, name = :name, tags = :tags, url = :url, image = :image, " +
           "price = :price, shipping = :shipping, stock = :stock, delivery_time = :deliveryTime, " +
           "offer = :offer, specification = :specification, details = :details, description = :description, " +
           "gallery = :gallery, video = :video, top_banner = :topBanner, default_banner = :defaultBanner, " +
           "horizontal_slider = :horizontalSlider, vertical_slider = :verticalSlider, reviews = :reviews " +
           "WHERE id = :id")
    Mono<Void> updateProductById(
            @Param("id") Long id,
            @Param("feedback") String feedback,
            @Param("store") String store,
            @Param("category") String category,
            @Param("titleList") String titleList,
            @Param("subCategory") String subCategory,
            @Param("name") String name,
            @Param("tags") String tags,
            @Param("url") String url,
            @Param("image") String image,
            @Param("price") Double price,
            @Param("shipping") Double shipping,
            @Param("stock") Integer stock,
            @Param("deliveryTime") String deliveryTime,
            @Param("offer") String offer,
            @Param("specification") String specification,
            @Param("details") String details,
            @Param("description") String description,
            @Param("gallery") String gallery,
            @Param("video") String video,
            @Param("topBanner") String topBanner,
            @Param("defaultBanner") String defaultBanner,
            @Param("horizontalSlider") String horizontalSlider,
            @Param("verticalSlider") String verticalSlider,
            @Param("reviews") String reviews
    );
}
