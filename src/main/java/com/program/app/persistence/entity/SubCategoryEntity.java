package com.program.app.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("subcategories")
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("category")
    private String category;

    @Column("title_list")
    private String titleList;

    @Column("name")
    private String name;

    @Column("url")
    private String url;

    @Column("image")
    private String image;

    @Column("products_inventory")
    private Integer productsInventory;

    @Column("view")
    private Integer view;
}
