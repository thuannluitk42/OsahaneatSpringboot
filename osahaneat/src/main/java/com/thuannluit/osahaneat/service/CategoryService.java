package com.thuannluit.osahaneat.service;

import com.thuannluit.osahaneat.dto.CategoryDTO;
import com.thuannluit.osahaneat.dto.MenuDTO;
import com.thuannluit.osahaneat.entity.Category;
import com.thuannluit.osahaneat.entity.Food;
import com.thuannluit.osahaneat.repository.CategoryRepository;
import com.thuannluit.osahaneat.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<CategoryDTO> getCategoryHomePage() {
        PageRequest pageRequest = PageRequest.of(0 ,3, Sort.by("id"));
        Page<Category> categoryList = categoryRepository.findAll(pageRequest);
        List<CategoryDTO> listCategoryDTOS = new ArrayList<>();
        for (Category data: categoryList){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(data.getName_cate());
            List<MenuDTO> menuDTOS = new ArrayList<>();
            for (Food dataFood : data.getListFood()) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setTitle(dataFood.getTitle());
                menuDTO.setFreeship(dataFood.isFreeship());
                menuDTO.setImage(dataFood.getImage());
                System.out.println(menuDTO.toString());
                menuDTOS.add(menuDTO);
            }
            categoryDTO.setMenus(menuDTOS);
            listCategoryDTOS.add(categoryDTO);
        }


        return listCategoryDTOS;
    }
}
