package com.program.app.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("feedback")
    private String feedback; // JSONB → String

    @Column("store")
    private String store;

    @Column("category")
    private String category;

    @Column("title_list")
    private String titleList;

    @Column("sub_category")
    private String subCategory;

    @Column("name")
    private String name;

    @Column("tags")
    private String tags; // JSONB → String

    @Column("url")
    private String url;

    @Column("image")
    private String image;

    @Column("price")
    private Double price;

    @Column("shipping")
    private Double shipping;

    @Column("stock")
    private Integer stock;

    @Column("delivery_time")
    private String deliveryTime; // JSONB → String

    @Column("offer")
    private String offer; // JSONB → String

    @Column("specification")
    private String specification; // HTML como texto

    @Column("details")
    private String details; // HTML como texto

    @Column("description")
    private String description; // HTML como texto

    @Column("gallery")
    private String gallery; // JSONB → String

    @Column("video")
    private String video; // JSONB → String

    @Column("top_banner")
    private String topBanner; // JSONB → String

    @Column("default_banner")
    private String defaultBanner;

    @Column("horizontal_slider")
    private String horizontalSlider; // JSONB → String

    @Column("vertical_slider")
    private String verticalSlider;

    @Column("reviews")
    private String reviews; // JSONB → String
}
