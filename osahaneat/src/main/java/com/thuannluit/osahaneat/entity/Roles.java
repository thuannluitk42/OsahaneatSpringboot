package com.thuannluit.osahaneat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name = "roles")
public class Roles extends BaseEntity {
    @Column(name = "role_name")
    private String role_name;

    @OneToMany(mappedBy = "roles")
    private Set<Users> listUser;
}
