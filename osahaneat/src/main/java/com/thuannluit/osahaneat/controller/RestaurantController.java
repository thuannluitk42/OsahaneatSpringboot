package com.thuannluit.osahaneat.controller;
import com.thuannluit.osahaneat.payload.ResponseData;
import com.thuannluit.osahaneat.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    FileServiceImp fileServiceImp;
    //upload file
    @PostMapping()
    public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file){
        ResponseData responseData = new ResponseData();
        responseData.setData(fileServiceImp.saveFile(file));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    //download file
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename){
        Resource resource = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }
}