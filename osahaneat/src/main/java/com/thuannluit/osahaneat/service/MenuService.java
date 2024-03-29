package com.thuannluit.osahaneat.service;

import com.thuannluit.osahaneat.entity.Category;
import com.thuannluit.osahaneat.entity.Food;
import com.thuannluit.osahaneat.entity.Restaurant;
import com.thuannluit.osahaneat.repository.FoodRepository;
import com.thuannluit.osahaneat.service.imp.FileServiceImp;
import com.thuannluit.osahaneat.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MenuService implements MenuServiceImp {
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    FoodRepository foodRepository;
    @Override
    public boolean createMenu(MultipartFile file, String title, boolean is_freeship, String time_ship, double price, int cate_id) {
        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess){
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTime_ship(time_ship);
                food.setPrice(price);
                food.setFreeship(is_freeship);

                Category category = new Category();
                category.setId(cate_id);

                food.setCategory(category);

                foodRepository.save(food);

                isInsertSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error insert menu: " + e.getMessage());
        }

        return isInsertSuccess;
    }
}
