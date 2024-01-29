package com.thuannluit.osahaneat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thuannluit.osahaneat.entity.keys.KeyMenuRestaurant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "menu_restaurant")
public class MenuRestaurant{
    @EmbeddedId
    KeyMenuRestaurant keys;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;
}
