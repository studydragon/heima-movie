package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.domain.Movie;
import com.itheima.mapper.MovieMapper;
import com.itheima.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> findAll() {
        QueryWrapper<Movie> wrapper = new QueryWrapper<>();//条件查询其 select * from tb_movie

        return movieMapper.selectList(wrapper);
    }

    @Override
    public void save(Movie movie) {
        movieMapper.insert(movie);
    }

    @Override
    public Movie findById(Integer id) {
        return movieMapper.selectById(id);
    }

    @Override
    public void update(Movie movie) {
        movieMapper.updateById(movie);
    }

    @Override
    public void deleteById(Integer id) {
        movieMapper.deleteById(id);
    }

    @Override
    public List<Movie> findByCid(Integer cid) {
        //select * from tb_movie where cid = ?
        QueryWrapper<Movie> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", cid);
        return movieMapper.selectList(wrapper);
    }
}
