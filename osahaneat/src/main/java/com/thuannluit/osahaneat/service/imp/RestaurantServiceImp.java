package com.thuannluit.osahaneat.service.imp;

import com.thuannluit.osahaneat.dto.RestaurantDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceImp {
    boolean insertRestaurant(MultipartFile file,
                             String title,
                             String subtitle,
                             String description,
                             boolean isFreeship,
                             String address,
                             String openDate);
    List<RestaurantDTO> getHomePageRestaurant();
}
