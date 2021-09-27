package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.domain.Member;
import com.itheima.mapper.MemberMapper;
import com.itheima.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    //1. SELECT * FROM tb_member WHERE username = 'tom' AND PASSWORD = '123456'
    //2. SELECT * FROM tb_member WHERE username = 'tom'  再比对密码

    @Override
    public Member login(String username, String password) {
        //1. 查询SELECT * FROM tb_member WHERE username = 'tom'  再比对密码
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Member member = memberMapper.selectOne(wrapper);
        if (member == null) {
            return null;
        }

        //2.如果查询到了会员,开始比对密码
        if (StringUtils.equals(member.getPassword(), password)) {
            //查到了会员,密码也对
            return member;
        }
        return null;
    }
}
