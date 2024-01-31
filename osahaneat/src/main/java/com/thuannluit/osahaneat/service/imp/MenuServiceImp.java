package com.thuannluit.osahaneat.service.imp;

import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
        boolean createMenu(MultipartFile file, String title,
                           boolean is_freeship, String time_ship,
                           double price, int cate_id);
}
