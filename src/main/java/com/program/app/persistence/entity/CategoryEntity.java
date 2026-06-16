package com.program.app.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("categories")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    // title_list es TEXT en la BD → lo mapeamos como String
    @Column("title_list")
    private String titleList;

    @Column("url")
    private String url;

    @Column("image")
    private String image;

    @Column("icon")
    private String icon;

    @Column("view")
    private Integer view;
}
