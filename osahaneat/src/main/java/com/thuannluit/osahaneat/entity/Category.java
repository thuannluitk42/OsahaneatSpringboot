package com.thuannluit.osahaneat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name = "Category")
public class Category extends BaseEntity{
    @Column(name = "name_cate")
    private String name_cate;

    @OneToMany(mappedBy = "category")
    private Set<Food> listFood;

    @OneToMany(mappedBy = "category")
    private Set<MenuRestaurant> listMenuRestaurant;
}
