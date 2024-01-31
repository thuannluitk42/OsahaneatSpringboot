package com.thuannluit.osahaneat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private String name;
    private List<MenuDTO> menus;

}
