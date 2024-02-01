package com.thuannluit.osahaneat.service;

import com.thuannluit.osahaneat.dto.CategoryDTO;
import com.thuannluit.osahaneat.dto.MenuDTO;
import com.thuannluit.osahaneat.dto.RestaurantDTO;
import com.thuannluit.osahaneat.entity.Food;
import com.thuannluit.osahaneat.entity.MenuRestaurant;
import com.thuannluit.osahaneat.entity.RatingRestaurant;
import com.thuannluit.osahaneat.entity.Restaurant;
import com.thuannluit.osahaneat.repository.RestaurantRepository;
import com.thuannluit.osahaneat.service.imp.FileServiceImp;
import com.thuannluit.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FileServiceImp fileServiceImp;
    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean isFreeship, String address, String openDate) {
        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess){
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setAddress(address);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeship(isFreeship);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
                Date open_date = simpleDateFormat.parse(openDate);
                restaurant.setOpenDate(open_date);
                restaurantRepository.save(restaurant);
                isInsertSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error insert restaurant: " + e.getMessage());
        }

        return isInsertSuccess;
    }

    @Override
    public List<RestaurantDTO> getHomePageRestaurant() {
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0,6);
        Page<Restaurant> listData = restaurantRepository.findAll(pageRequest);
        RestaurantDTO restaurantDTO;
        for (Restaurant data:listData) {
            restaurantDTO = new RestaurantDTO();
            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setFreeship(data.isFreeship());
            restaurantDTO.setSubtitle(data.getSubtitle());
            restaurantDTO.setRating(caculatorRating(data.getListRatingRestaurant()));
            restaurantDTOS.add(restaurantDTO);
        }
        return restaurantDTOS;
    }

    private double caculatorRating(Set<RatingRestaurant> listRating){
        double totalPoint = 0;
        for (RatingRestaurant data: listRating) {
            totalPoint += data.getRatePoint();
        }
        // diem trung binh = tong diem / so luot
        return totalPoint/listRating.size();
    }

    @Override
    public RestaurantDTO getDetailRestaurant(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        // kiem tra null, trong, co du lieu
        if (restaurant.isPresent()){
            Restaurant data = restaurant.get();
            List<CategoryDTO> listCategory = new ArrayList<>();

            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubtitle(data.getSubtitle());
            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setRating(caculatorRating(data.getListRatingRestaurant()));
            restaurantDTO.setFreeship(data.isFreeship());
            restaurantDTO.setOpenDate(data.getOpenDate());

            //category
            for (MenuRestaurant menuRestaurant:data.getListMenuRestaurant()) {
                List<MenuDTO> menuDTOList = new ArrayList<>();
                CategoryDTO categoryDTO = new CategoryDTO();

                categoryDTO.setName(menuRestaurant.getCategory().getName_cate());
                for(Food food:menuRestaurant.getCategory().getListFood()){
                    MenuDTO menuDTO = new MenuDTO();
                    menuDTO.setImage(food.getImage());
                    menuDTO.setFreeship(food.isFreeship());
                    menuDTO.setTitle(food.getTitle());

                    menuDTOList.add(menuDTO);
                }
                categoryDTO.setMenus(menuDTOList);
                listCategory.add(categoryDTO);
            }
            restaurantDTO.setListCategory(listCategory);
        }
        return restaurantDTO;
    }
}
