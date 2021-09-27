package com.itheima.service;

import com.itheima.domain.Movie;

import java.util.List;

public interface MovieService {

    //查询影视列表
    List<Movie> findAll();

    //保存影视
    void save(Movie movie);

    //根据影视id查询影视详情
    Movie findById(Integer id);

    //根据id更新影视详情
    void update(Movie movie);

    //根据id删除影视
    void deleteById(Integer id);

    //根据栏目id查询影视列表
    List<Movie> findByCid(Integer cid);
}
