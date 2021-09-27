package com.itheima.web.controller;

import com.itheima.domain.Member;
import com.itheima.service.MemberService;
import com.itheima.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/member/login")
    public Map<String, String> login(String username, String password) {
        //1. 登录
        Member member = memberService.login(username, password);

        //2. 处理结果
        HashMap<String, String> resultMap = new HashMap<>();
        if (member == null) {
            //登陆失败
            resultMap.put("code", "0");
        } else {
            //登陆成功
            resultMap.put("code", "1");
            resultMap.put("username", member.getUsername());

            //创建token,返回给浏览器
            HashMap<String, String> tokenMap = new HashMap<>();
            tokenMap.put("id", member.getId().toString());
            tokenMap.put("username", member.getUsername());
            String token = JwtUtil.createToken(tokenMap);
            System.out.println(member.getUsername() + "生成的token是" + token);
            resultMap.put("token", token);
        }
        return resultMap;
    }
}
