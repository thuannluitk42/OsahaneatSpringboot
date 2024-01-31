package com.thuannluit.osahaneat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "is_freeship")
    private boolean isFreeship;
    @Column(name = "time_ship")
    private String time_ship;
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;
    @OneToMany(mappedBy = "food")
    private Set<RatingFood> listRatingFood;
    @OneToMany(mappedBy = "food")
    private Set<OrderItem> listOrdersItem;
}
