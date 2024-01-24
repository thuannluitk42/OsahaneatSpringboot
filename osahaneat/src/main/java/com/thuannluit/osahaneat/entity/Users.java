package com.thuannluit.osahaneat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name = "Users")
public class    Users extends  BaseEntity{

    @Column(name = "user_name")
    private String user_name;
    @Column(name = "password")
    private String password ;
    @Column(name = "fullname")
    private String fullname ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> listRatingFood;

    @OneToMany(mappedBy = "user")
    private Set<RatingRestaurant> listRatingRestaurant;

    @OneToMany(mappedBy = "user")
    private Set<Orders> listOrders;

}
