package com.thuannluit.osahaneat.entity;

import com.thuannluit.osahaneat.entity.keys.KeyOrdersItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "order_item")
public class OrderItem {

    @EmbeddedId
    KeyOrdersItem keys;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "price")
    private double price;
}
