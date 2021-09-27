package com.itheima.web.controller;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //查询导航栏
    @RequestMapping("/category/findAll")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
}
