package com.itheima.web.controller;


import com.itheima.domain.Movie;
import com.itheima.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//controller---service----mapper

@RestController
//@Controller
//@ResponseBody  //返回值放到相应
public class MovieController {

    @Autowired
    private MovieService movieService;

    //查询影视列表
    @RequestMapping("/movie/findAll")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    //新增影视
    @RequestMapping("/movie/save")
    public void save(@RequestBody Movie movie) {
        //System.out.println(movie);
        if (movie.getId() == null){
            //新增
            movieService.save(movie);
        }else{
            //修改
            movieService.update(movie);
        }
    }

    //根据影视id查询
    @RequestMapping("/movie/findById")
    public Movie findById(Integer id) {
        return movieService.findById(id);
    }

    //根据id删除
    @RequestMapping("/movie/deleteById")
    public void deleteById(Integer id){
        movieService.deleteById(id);
    }


}
