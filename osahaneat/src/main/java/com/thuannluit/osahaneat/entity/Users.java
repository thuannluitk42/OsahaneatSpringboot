package com.thuannluit.osahaneat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
public class Users extends BaseEntity {

    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password ;
    @Column(name = "fullname")
    private String fullname ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> listRatingFood;

    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> listRatingRestaurant;

    @OneToMany(mappedBy = "users")
    private Set<Orders> listOrders;

}
