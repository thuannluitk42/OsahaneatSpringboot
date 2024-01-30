package com.thuannluit.osahaneat.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDTO {
    private String title;
    private String subtitle;
    private String image;
    private boolean isFreeship;
    private double rating;
}
