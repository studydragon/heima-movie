package com.itheima.web.controller;

import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.itheima.domain.Movie;
import com.itheima.service.MovieService;
import com.itheima.util.VodUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {


    @Autowired
    private MovieService movieService;

    //根据栏目id查询影视列表
    @RequestMapping("/movie/findByCid")
    public List<Movie> findByCid(Integer cid){
        return movieService.findByCid(cid);
    }


    //根据影视id查询电影的详情
    @RequestMapping("/movie/findById")
    public Movie findById(Integer id) throws Exception {
        //1. 首先根据电影的id从数据库中查询电影详情
        Movie movie = movieService.findById(id);

        //2. 根据电影的palyId查询它的playAuth(从阿里云查询)
        String playAuth = VodUtil.getVideoPlayAuth(movie.getPlayId()).getPlayAuth();
        movie.setPlayAuth(playAuth);

        //3. 返回movie
        return movie;
    }
}
