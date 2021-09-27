package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//会员
@TableName("tb_member")
public class Member implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;//主键

    private String username;//用户名

    private String password;//密码

    private String phone;//手机
}