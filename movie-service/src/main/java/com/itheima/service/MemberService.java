package com.itheima.service;

import com.itheima.domain.Member;

public interface MemberService {
    //登录
    Member login(String username, String password);
}
